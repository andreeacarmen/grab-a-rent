package hg;

import java.util.ArrayList;
import java.util.function.Consumer;

public class PropertyBuilder {
    public Long id;
    public String propertyName;
    public String propType;
    public double mp;
    public double price;
    public double lat;
    public double lg;
    public boolean furniture;
    public int constructionYear;
    public int lvl;
    public int roomNr;
    public String description;
    public ArrayList<String> facilities;
    public String address;
    public String utilities;
    public String state;
    public String heating;
    public Long userId;
    public String pictureURL;


    public Property createProperty() {
        return new Property(id, propertyName, propType, mp, price, lat, lg, furniture, constructionYear, lvl, roomNr, description, facilities,
        address,utilities,state,heating,userId, pictureURL);
    }

    public PropertyBuilder with (Consumer<PropertyBuilder> builderFunction) {
        builderFunction.accept(this);
        return this; }

}