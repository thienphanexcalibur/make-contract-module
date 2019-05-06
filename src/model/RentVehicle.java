package model;

import java.util.*;

public class RentVehicle {

    private int ID;
    private int contractID;
    private int punishID;
    private int vehicleID;
    private int clientID;
    private String description;
    private float price;

    public RentVehicle(int ID, int contractID, int punishID, int vehicleID, int clientID, String description, float price) {
        this.ID = ID;
        this.contractID = contractID;
        this.punishID = punishID;
        this.vehicleID = vehicleID;
        this.clientID = clientID;
        this.description = description;
        this.price = price;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getClientID() {
        return clientID;
    }

    public int getID() {
        return ID;
    }

    public int getContractID() {
        return contractID;
    }

    public int getPunishID() {
        return punishID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public void setPunishID(int punishID) {
        this.punishID = punishID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
