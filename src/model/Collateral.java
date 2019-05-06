package model;

public class Collateral {

    private int ID;
    private int contractID;
    private String name;
    private float value;

    public Collateral(int ID, int contractID, String name, float value) {
        this.ID = ID;
        this.contractID = contractID;
        this.name = name;
        this.value = value;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

}
