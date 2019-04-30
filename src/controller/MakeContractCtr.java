/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.SQLException;
import view.MakeContractFrm;
import model.BaseDAO;
import model.ClientDAO;
import model.Client;
import java.util.ArrayList;

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
       }  
       
       private void fetchData() {
           try {
                Client client = new ClientDAO().getClient(selectedClientID);
                mMakeContractFrm.labelfullname.setText(client.getName());
                mMakeContractFrm.labeldob.setText(client.getBirthday());
                mMakeContractFrm.labelphone.setText(client.getPhone());
                mMakeContractFrm.labelEmail.setText(client.getEmail());
                mMakeContractFrm.labeldescription.setText(client.getDescription());
           } catch (SQLException e) {
               System.out.println(e);
           }
       }
}
