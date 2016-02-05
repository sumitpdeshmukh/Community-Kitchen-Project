/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;


import Business.Enterprise.Enterprise;
import Business.KitchenSystem;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.AdministrativeRole.AdminWorkAreaJPanel;

/**
 *
 * @author Sumit
 */
public class AdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, KitchenSystem system) {
        return new AdminWorkAreaJPanel(userProcessContainer, enterprise);
    }

   @Override
    public String toString() {
        return "AdminRole";
    }

    
    
}
