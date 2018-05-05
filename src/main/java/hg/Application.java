package hg;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class Application {

    private final ArrayList<User> users = new ArrayList() {
        {
            add(new UserBuilder().createUser());
            add(new UserBuilder().createUser());
            add(new UserBuilder().createUser());
            add(new UserBuilder().createUser());
            add(new UserBuilder().createUser());
            add(new UserBuilder().createUser());
            add(new UserBuilder().createUser());
        }
    };

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {

        return (evt) -> users
                .forEach(
                        a -> {
                            userRepository.save(a);
                        });
    }

}