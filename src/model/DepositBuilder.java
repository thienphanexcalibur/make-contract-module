/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Deposit;

/**
 *
 * @author justj
 */
public class DepositBuilder {

    private int ID;
    private int contractID;
    private String description;
    private float amount;

    public DepositBuilder() {
    }

    public DepositBuilder setID(int ID) {
        this.ID = ID;
        return this;
    }

    public DepositBuilder setContractID(int contractID) {
        this.contractID = contractID;
        return this;
    }

    public DepositBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public DepositBuilder setAmount(float amount) {
        this.amount = amount;
        return this;
    }

    /**
     *
     * @return Deposit
     */
    public Deposit buildDeposit() {
        return new Deposit(ID, contractID, description, amount);
    }
}
