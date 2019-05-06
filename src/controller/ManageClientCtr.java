/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import model.ClientDAO;
import model.Client;
import view.ManageClientFrm;
import view.MakeContractFrm;
import view.AddClientFrm;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author justj
 */
public class ManageClientCtr {

    private ManageClientFrm mManageClientFrm;
    private MakeContractFrm mMakeContractFrm;
    private AddClientFrm mAddClientFrm;

    private DefaultTableModel mClientTable;
    private int selectedClientID = 0;

    public ManageClientCtr(ManageClientFrm manageClientFrm) {
        mManageClientFrm = manageClientFrm;
        mClientTable = (DefaultTableModel) mManageClientFrm.clientTable.getModel();
        mounted();
        fetchData();
    }

    ;

    /**
     * Add row on client table
     * @param client
     */
    private void addRow(Client client) {
        mClientTable.addRow(new Object[]{client.getID(), client.getName(), client.getBirthday(), client.getEmail(), client.getPhone()});
    }

    /**
     * When manage client form mounted
     */
    private void mounted() {
        /**
         * Fetch client contract
         */
        mManageClientFrm.btnMakeContract.addActionListener((ActionEvent e) -> {
            int selectedRow;
            selectedRow = mManageClientFrm.clientTable.getSelectedRow();
            if (selectedRow >= 0) {
                selectedClientID = (int) mClientTable.getValueAt(selectedRow, 0);
                mMakeContractFrm = new MakeContractFrm(selectedClientID);
                mMakeContractFrm.setLocationRelativeTo(null);
                mMakeContractFrm.setVisible(true);
            }
        });
        mAddClientFrm = new AddClientFrm();

        mManageClientFrm.btnAddClient.addActionListener(e -> {

            mAddClientFrm.setLocationRelativeTo(null);
            mAddClientFrm.setVisible(true);
        });

        mManageClientFrm.btnDeleteClient.addActionListener(e -> {
            int selectedRow;
            selectedRow = mManageClientFrm.clientTable.getSelectedRow();
            if (selectedRow >= 0) {
                selectedClientID = (int) mClientTable.getValueAt(selectedRow, 0);
                try {
                    new ClientDAO().deleteClient(selectedClientID);
                    JOptionPane.showMessageDialog(mAddClientFrm, "Success");
                    mClientTable.removeRow(selectedRow);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            fetchData();
        });
    }

    /**
     * Fetch Data from DB
     */
    private void fetchData() {
        try {
            ArrayList<Client> result = new ClientDAO().getClients();
            result.forEach((client) -> {
                addRow(client);
            });
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
