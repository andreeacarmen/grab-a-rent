package hg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
class UserRestController {

    private final UserRepository userRepository;


    @Autowired
    UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET,
                    value = "/{userId}")
    User userDetails(@PathVariable Long userId) {
        this.validateUser(userId);
        return this.userRepository.findById(userId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET)
    List<User> allUsers() {
        return this.userRepository.findAllByOrderByIdAsc();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST,
            value = "/new",
            headers="Accept=application/json",
            produces= MediaType.APPLICATION_JSON_VALUE,
            consumes="*/*")
    ResponseEntity<?> add(@RequestBody User user) {

        User newUser = userRepository.save(
                new UserBuilder()
                        .with( userBuilder ->  {
                            userBuilder.name = user.getName();
                            userBuilder.password = user.getPassword();
                            userBuilder.email = user.getEmail();
                            userBuilder.location = user.getLocation();
                            userBuilder.telefonNr = user.getTelefonNr();
                        }). createUser()
                );

        System.out.println(newUser.getName());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(location).build();

    }


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST,
            value = "/edit",
            headers="Accept=application/json",
            produces= MediaType.APPLICATION_JSON_VALUE,
            consumes="*/*")
    ResponseEntity<?> edit(@RequestBody User user) {

        User userR = userRepository.findByEmail(user.getEmail());
        userRepository.delete(userR);

        User newUser = userRepository.save(new UserBuilder().createUser());
        System.out.println(newUser.getEmail());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST,
            value = "/login",
            headers="Accept=application/json",
            consumes="*/*")
    public User auth(@RequestBody Credentials cred){
        String email = cred.email;
        String password = cred.password;

        System.out.println("email" + email + "password " + password);
      //  String password = "" + cred.password.hashCode();

        User user = this.userRepository.findByEmail(email);
        System.out.println(email);
        if(user == null || user.getPassword().compareTo(cred.password) != 0){
            System.out.println("null");
            return null;
        } else {
           /* UUID uuid =  UUID.randomUUID();
            System.out.println(uuid);*/
            return user;
        }
    }

    public void validateUser(Long userId) {
        if(userRepository.findById(userId) == null) {
            throw new UserNotFoundException(userId);
        }
    }
}