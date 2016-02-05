/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;


import Business.Enterprise.Enterprise;
import Business.KitchenSystem;
import Business.Organization.CoordinatorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.CoordinatorRole.CoordinatorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Sumit
 */
public class CoordinatorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, KitchenSystem system) {
        return new CoordinatorWorkAreaJPanel(userProcessContainer, account, 
                (CoordinatorOrganization)organization, enterprise);
    }

    @Override
    public String toString() {
        return "Coordinator Role";
    } 
   
}
