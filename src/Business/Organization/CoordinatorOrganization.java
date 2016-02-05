/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CoordinatorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sumit
 */
public class CoordinatorOrganization extends Organization{
    
    public CoordinatorOrganization() {
        super(Organization.Type.Coordinator.getValue());
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CoordinatorRole());
        return roles;
    }
     
   
    
    
}
