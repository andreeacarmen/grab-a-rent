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
    @RequestMapping(method = RequestMethod.GET,
            value = "/filter")
    @ResponseBody
    List<Property> getFilteredProperties(@RequestParam(value = "price", required = false) double price,
                                         @RequestParam(value = "lvl", required = false) int lvl,
                                         @RequestParam(value = "constructionYear", required = false) int constructionYear,
                                         @RequestParam(value = "propType", required = false) String propType) {
        return this.propertyRepository.findPropertyByPriceAndLvlAndPropTypeAndConstructionYear(price, lvl, propType, constructionYear);
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
                            propertyBuilder.lat = property.getLat();
                            propertyBuilder.lg = property.getLg();
                            propertyBuilder.constructionYear = property.getConstructionYear();
                            propertyBuilder.facilities = property.getFacilities();
                            propertyBuilder.userId = property.getUserId();
                        }). createProperty()
        );

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/home")
                .buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/{userId}")
    @CrossOrigin(origins = "http://localhost:3000")
    List<Property> getPropertyByUserId(@PathVariable Long userId) {
        return this.propertyRepository.findPropertyByUserId(userId);
    }

}
