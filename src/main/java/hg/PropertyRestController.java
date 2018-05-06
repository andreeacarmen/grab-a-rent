package hg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by Andreea on 06.05.2018.
 */

@RestController
@RequestMapping("/properties")
public class PropertyRestController {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyRestController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET)
    List<Property> allProperties() {
        return this.propertyRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST,
            value = "/new",
            headers="Accept=application/json",
            produces= MediaType.APPLICATION_JSON_VALUE,
            consumes="*/*")
    ResponseEntity<?> add(@RequestBody Property property) {

        Property newUser = propertyRepository.save(
                new PropertyBuilder()
                        .with( propertyBuilder ->  {
                            propertyBuilder.price = property.getPrice();
                            propertyBuilder.propType = property.getPropType();
                            propertyBuilder.lvl = property.getLvl();
                            propertyBuilder.mp = property.getMp();
                            propertyBuilder.constructionYear = property.getConstructionYear();
                            propertyBuilder.facilities = property.getFacilities();
                        }). createProperty()
        );

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
