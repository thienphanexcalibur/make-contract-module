package model;

public class Deposit {

    private int ID;
    private int contractID;
    private String description;
    private float amount;

    public Deposit(int ID, int contractID, String description, float amount) {
        this.ID = ID;
        this.contractID = contractID;
        this.description = description;
        this.amount = amount;
    }

    public int getID() {
        return ID;
    }

    public int getContractID() {
        return contractID;
    }

    public String getDescription() {
        return description;
    }

    public float getAmount() {
        return amount;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

}
