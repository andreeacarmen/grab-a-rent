package hg;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class Application {

    private final ArrayList<User> users = new ArrayList() {
        {
            add(new UserBuilder().with( userBuilder ->  {
                userBuilder.email = "andreea-carmen@gmail.com";
                userBuilder.name = "Andreea";
                userBuilder.password = "parola";
            }).createUser());
        }
    };

    private final ArrayList<Property> properties = new ArrayList() {
        {
           add(new PropertyBuilder()
                    .with( propertyBuilder ->  {
                        propertyBuilder.propertyName = "Apartament LUX";
                        propertyBuilder.price = 350;
                        propertyBuilder.propType = "Decomandat";
                        propertyBuilder.lvl = 1;
                        propertyBuilder.state = "decomandat";
                        propertyBuilder.address = "Strada Petalelor, Bucuresti";
                        propertyBuilder.mp = 70;
                        propertyBuilder.lat =44.426767;
                        propertyBuilder.lg = 26.102538;
                        propertyBuilder.utilities = "neutilat";
                        propertyBuilder.heating = "system";
                        propertyBuilder.constructionYear = 2017;
                        propertyBuilder.pictureURL = "prop_img1.jpg";
                        propertyBuilder.userId = new Long(1);
                    }). createProperty());
            add(new PropertyBuilder()
                    .with( propertyBuilder ->  {
                        propertyBuilder.propertyName = "Apartament zona deosebita";
                        propertyBuilder.price = 350;
                        propertyBuilder.propType = "Semidecomandat";
                        propertyBuilder.lvl = 1;
                        propertyBuilder.mp = 70;
                        propertyBuilder.state = "semidecomandat";
                        propertyBuilder.address = "Strada Verzelor, Bucuresti";
                        propertyBuilder.utilities = "partial";
                        propertyBuilder.heating = "own";
                        propertyBuilder.constructionYear = 2018;
                        propertyBuilder.roomNr = 2;
                        propertyBuilder.lat =44.436767;
                        propertyBuilder.lg = 26.102538;
                        propertyBuilder.pictureURL = "prop_img2.jpg";
                        propertyBuilder.facilities = new ArrayList<>(Arrays.asList("incalzire", "balcon"));
                        propertyBuilder.userId = new Long(1);
                    }). createProperty());
        }
    };

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, PropertyRepository propertyRepository) {

        properties.forEach(a -> {
            propertyRepository.save(a);
        });
        return (evt) -> users
                .forEach(
                        a -> {
                            userRepository.save(a);
                        });
    }

}