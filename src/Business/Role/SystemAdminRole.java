/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.KitchenSystem;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.AdministrativeRole.SystemAdminWorkAreaJPanel;


/**
 *
 * @author Sumit
 */
public class SystemAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization,
            Enterprise enterprise, KitchenSystem system) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer, system);
    }
    
    @Override
    public String toString() {
        return "SystemAdminRole";
    } 
}
