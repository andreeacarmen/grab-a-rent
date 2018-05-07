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


    public Property createProperty() {
        return new Property(id, propertyName, propType, mp, price, lat, lg, furniture, constructionYear, lvl, roomNr, description, facilities);
    }

    public PropertyBuilder with (Consumer<PropertyBuilder> builderFunction) {
        builderFunction.accept(this);
        return this; }

}