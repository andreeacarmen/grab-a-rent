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

    private String propertyName;
    private String propType;
    private double mp;
    private double price;
    private double lat;
    private double lg;
    private boolean furniture;
    private int constructionYear;
    private int lvl;
    private int roomNr;
    private String description;
    private ArrayList<String> facilities;

    public Property() {
    }


    public Property(Long id, String propertyName, String propType, double mp, double price, double lat, double lg, boolean furniture, int constructionYear, int lvl, int roomNr, String description, ArrayList<String> facilities) {
        this.id = id;
        this.propertyName = propertyName;
        this.propType = propType;
        this.mp = mp;
        this.price = price;
        this.lat = lat;
        this.lg = lg;
        this.furniture = furniture;
        this.constructionYear = constructionYear;
        this.lvl = lvl;
        this.roomNr = roomNr;
        this.description = description;
        this.facilities = facilities;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
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

    public int getRoomNr() {
        return roomNr;
    }

    public void setRoomNr(int roomNr) {
        this.roomNr = roomNr;
    }

    public ArrayList<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(ArrayList<String> facilities) {
        this.facilities = facilities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
