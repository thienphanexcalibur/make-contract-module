/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Collateral;

/**
 *
 * @author justj
 */
public class CollateralBuilder {

    private int ID;
    private int contractID;
    private String name;
    private float value;

    public CollateralBuilder() {
    }

    public CollateralBuilder setID(int ID) {
        this.ID = ID;
        return this;
    }

    public CollateralBuilder setContractID(int contractID) {
        this.contractID = contractID;
        return this;
    }

    public CollateralBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CollateralBuilder setValue(float value) {
        this.value = value;
        return this;
    }

    public Collateral buildCollateral() {
        return new Collateral(ID, contractID, name, value);
    }
}
