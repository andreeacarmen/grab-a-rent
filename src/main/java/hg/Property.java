package hg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;

/**
 * Created by Andreea on 06.05.2018.
 */

@Entity
public class Property {
    @javax.persistence.Id
    @GeneratedValue
    private Long id;

    private String propType;
    private double mp;
    private double price;
    private double lat;
    private double lg;
    private boolean furniture;
    private int constructionYear;
    private int lvl;
    private int type;
    private ArrayList<String> facilities;


    public Property(Long id, String propType, double mp, double price, double lat, double lg, boolean furniture, int constructionYear, int lvl, ArrayList<String> facilities) {
        this.id = id;
        this.propType = propType;
        this.mp = mp;
        this.price = price;
        this.lat = lat;
        this.lg = lg;
        this.furniture = furniture;
        this.constructionYear = constructionYear;
        this.lvl = lvl;
        this.facilities = facilities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropType() {
        return propType;
    }

    public void setPropType(String propType) {
        this.propType = propType;
    }

    public double getMp() {
        return mp;
    }

    public void setMp(double mp) {
        this.mp = mp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLg() {
        return lg;
    }

    public void setLg(double lg) {
        this.lg = lg;
    }

    public boolean isFurniture() {
        return furniture;
    }

    public void setFurniture(boolean furniture) {
        this.furniture = furniture;
    }

    public int getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(ArrayList<String> facilities) {
        this.facilities = facilities;
    }
}
