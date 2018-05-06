package hg;

import java.util.ArrayList;
import java.util.function.Consumer;

public class PropertyBuilder {
    public Long id;
    public String propType;
    public double mp;
    public double price;
    public double lat;
    public double lg;
    public boolean furniture;
    public int constructionYear;
    public int lvl;
    public ArrayList<String> facilities;


    public Property createProperty() {
        return new Property(id, propType, mp, price, lat, lg, furniture, constructionYear, lvl, facilities);
    }

    public PropertyBuilder with (Consumer<PropertyBuilder> builderFunction) {
        builderFunction.accept(this);
        return this; }

}