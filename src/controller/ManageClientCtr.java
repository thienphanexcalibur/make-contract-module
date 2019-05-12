/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import model.Client;
import view.ManageClientFrm;
import view.MakeContractFrm;
import view.ShowContractFrm;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author justj
 */
public class ManageClientCtr {

    private ManageClientFrm mManageClientFrm;
    private MakeContractFrm mMakeContractFrm;
    private ShowContractFrm mAddClientFrm;

    private DefaultTableModel mClientTable;
    private int selectedClientID = 0;
    public Boolean firstMounted = true;

    public ManageClientCtr(ManageClientFrm manageClientFrm) {
        mManageClientFrm = manageClientFrm;
        mClientTable = (DefaultTableModel) mManageClientFrm.clientTable.getModel();
        mounted();
        fetchData();
    }

    /**
     * Add row on client table
     *
     * @param client
     */
    private void addRow(Client client) {
        mClientTable.addRow(new Object[]{client.getID(), client.getName(), client.getBirthday(), client.getEmail(), client.getPhone(), client.getContractID()});
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
        mAddClientFrm = new ShowContractFrm();

//        mManageClientFrm.btnRefresh.addActionListener(e -> {
//
//        });
        mManageClientFrm.btnShowContract.addActionListener(e -> {
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
