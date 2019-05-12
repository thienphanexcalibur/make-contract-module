/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import view.MakeContractFrm;
import view.ManageClientFrm;
import model.DepositBuilder;
import model.CollateralBuilder;
import model.Client;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Collateral;
import javax.swing.DefaultListModel;
import model.Vehicle;

/**
 *
 * @author justj
 */
public class MakeContractCtr {

    private MakeContractFrm mMakeContractFrm;
    private int selectedClientID;

    public MakeContractCtr(MakeContractFrm makeContractFrm) {
        mMakeContractFrm = makeContractFrm;
        mounted();
        fetchData();
    }

    private void mounted() {
        selectedClientID = mMakeContractFrm.clientID;

        mMakeContractFrm.btnDone.addActionListener(e -> {
            String startDate = mMakeContractFrm.inputStartDate.getText();
            String endDate = mMakeContractFrm.inputEndDate.getText();
            String collateralName = mMakeContractFrm.inputColatName.getText();
            float collateralValue = Float.parseFloat(mMakeContractFrm.inputColatValue.getText());
            float depositAmount = Float.parseFloat(mMakeContractFrm.inputDepositAmount.getText());
            int vehicleID = Integer.parseInt(mMakeContractFrm.JListVehicles.getSelectedValue().substring(0, 1));

            System.out.println(vehicleID);
            DepositBuilder depositBuilder = new DepositBuilder();
            depositBuilder.setAmount(depositAmount);

            CollateralBuilder collateralBuilder = new CollateralBuilder();
            collateralBuilder.setName(collateralName).setValue(collateralValue);

            // Test case :)
            if (depositAmount <= 0) {
                JOptionPane.showMessageDialog(mMakeContractFrm, "Deposit must be above zero");
            } else if (collateralName.isEmpty()) {
                JOptionPane.showMessageDialog(mMakeContractFrm, "Collateral must be included");
            } else if (collateralValue <= 0) {
                JOptionPane.showMessageDialog(mMakeContractFrm, "Collateral value must be above zero");
            } else {
                // Start inject to DB
                int createContract = new ContractDAO().createContract(selectedClientID, startDate, endDate, collateralBuilder.buildCollateral(), depositBuilder.buildDeposit(), vehicleID);

                if (createContract == 1) {
                    JOptionPane.showMessageDialog(mMakeContractFrm, "Make Contract Success!!!!!!!");
                    mMakeContractFrm.dispose();
                } else {
                    JOptionPane.showMessageDialog(mMakeContractFrm, "Database Error, please try again :)");
                }
            }
        });

    }

    private void fetchVehicles() throws SQLException {
        ArrayList<Vehicle> listVehicles = new ContractDAO().getVehicles();
        DefaultListModel<String> lv = new DefaultListModel<>();
        for (int i = 0; i <= listVehicles.size() - 1; i++) {
            lv.add(i, listVehicles.get(i).getID() + ". " + listVehicles.get(i).getName());
            System.out.println(listVehicles.get(i).getName());
        }
        mMakeContractFrm.JListVehicles.setModel(lv);
    }

    private void fetchData() {
        try {
            Client client = new ClientDAO().getClient(selectedClientID);
            mMakeContractFrm.labelfullname.setText(client.getName());
            mMakeContractFrm.labeldob.setText(client.getBirthday());
            mMakeContractFrm.labelphone.setText(client.getPhone());
            mMakeContractFrm.labelEmail.setText(client.getEmail());
            fetchVehicles();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
