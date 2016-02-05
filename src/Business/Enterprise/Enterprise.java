/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;


import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.AdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sumit
 */
public class Enterprise extends Organization{
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationList;
    
    public Enterprise(String name, EnterpriseType et) {
        super(name);
        this.enterpriseType = et;
        this.organizationList = new OrganizationDirectory();
       
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AdminRole());
        return roles;
    }
    
    public enum EnterpriseType {
        Kitchen("Kitchen");
        private String value;
        private EnterpriseType(String val) {
            this.value = val;
        }

        public String getValue() {
            return value;
        }
        
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public OrganizationDirectory getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(OrganizationDirectory organizationList) {
        this.organizationList = organizationList;
    }
    
    
}
