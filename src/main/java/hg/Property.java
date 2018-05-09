package hg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import java.net.URL;
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
    private String address;
    private String utilities;
    private String state;
    private String heating;

    private Long userId;
    private String pictureURL;

    public Property() {
    }


    public Property(Long id, String propertyName, String propType, double mp, double price, double lat, double lg, boolean furniture, int constructionYear, int lvl, int roomNr, String description,
                    ArrayList<String> facilities, String address, String utilities, String state, String heating, Long userId, String pictureURL) {
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
        this.address = address;
        this.utilities = utilities;
        this.state = state;
        this.heating = heating;
        this.userId = userId;
        this.pictureURL = pictureURL;
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


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getHeating() {
        return heating;
    }

    public void setHeating(String heating) {
        this.heating = heating;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getUtilities() {
        return utilities;
    }

    public void setUtilities(String utilities) {
        this.utilities = utilities;
    }
}
