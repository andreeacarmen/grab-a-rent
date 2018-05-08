package hg;

import java.util.function.Consumer;

public class UserBuilder {
    public String name;
    public String location;
    public String email;
    public String telefonNr;
    public String password;

    public UserBuilder with (Consumer<UserBuilder> builderFunction) {
        builderFunction.accept(this);
        return this; }


    public User createUser() {
        return new User(name, location, email, telefonNr, password);
    }
}