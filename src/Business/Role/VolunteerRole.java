/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.KitchenSystem;
import Business.Organization.Organization;
import Business.Organization.VolunteerOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.VolunteerRole.VolunteerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Sumit
 */
public class VolunteerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, 
            Enterprise enterprise, KitchenSystem system) {
        return new VolunteerWorkAreaJPanel(userProcessContainer, account, (VolunteerOrganization)organization, 
                enterprise);
    }    
    
    @Override
    public String toString() {
        return "Volunteer Role";
    } 
}
