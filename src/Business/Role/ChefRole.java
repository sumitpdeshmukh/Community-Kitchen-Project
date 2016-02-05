/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;


import Business.Enterprise.Enterprise;
import Business.KitchenSystem;
import Business.Organization.ChefOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.ChefRole.ChefWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Sumit
 */
public class ChefRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, KitchenSystem ecosystem) {
        return new ChefWorkAreaJPanel(userProcessContainer, account, (ChefOrganization)organization, 
                enterprise);
    }

   @Override
    public String toString() {
        return "Chef Role";
    } 
    
    
}
