/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author Sumit
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Chef.getValue())){
            organization = new ChefOrganization();
            
        }  else if (type.getValue().equals(Organization.Type.Volunteer.getValue())){
            organization = new VolunteerOrganization();
            
        }  else if (type.getValue().equals(Organization.Type.Supplier.getValue())){
            organization = new SupplierOrganization();
            
        }  else if (type.getValue().equals(Organization.Type.Coordinator.getValue())){
            organization = new CoordinatorOrganization();
            
        }
        organizationList.add(organization);
        return organization;
    }
}
