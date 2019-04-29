/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.swing.*;
import view.ManageClientFrm;

/**
 *
 * @author justj
 */
public class ManageClientCtr {
    ManageClientFrm mManageClientFrm;
    public ManageClientCtr(ManageClientFrm manageClientFrm) {
       mManageClientFrm = manageClientFrm;
       this.mounted();
    };
    
    
    public void mounted () {
       mManageClientFrm.btnAddClient.addActionListener(e -> {
           System.out.println(e);
       });
    }
}
