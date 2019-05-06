package model;

public class Vehicle {

    private int ID;
    private int brandID;
    private String name;
    private String type;
    private float price;
    private String description;

    public Vehicle(int ID, int brandID, String name, String type, float price, String description) {
        this.ID = ID;
        this.brandID = brandID;
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
