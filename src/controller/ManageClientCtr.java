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
    
    public ManageClientCtr(ManageClientFrm manageClientFrm) {
       mManageClientFrm = manageClientFrm;
       mClientTable = (DefaultTableModel) mManageClientFrm.clientTable.getModel();
       mounted();
       fetchData();
    };
    
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
    private void mounted () {
       
        mManageClientFrm.btnMakeContract.addActionListener((ActionEvent e) -> {
                int selectedRow;
                int selectedClientID = 0;
                selectedRow = mManageClientFrm.clientTable.getSelectedRow();
                System.out.print(selectedRow);
                if (selectedRow >=0 ) {
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
       } catch(SQLException e) {
           System.out.println(e);
       }
    }
    
 
}
