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

/**
 *
 * @author Sumit
 */
public abstract class Role {
    public enum RoleType{
        Admin("Admin"),
        Supplier("Supplier"),
        Volunteer("Volunteer"),
        Chef("Chef"),
        Coordinator("Coordinator");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,
            Organization organization, Enterprise enterprise, KitchenSystem ecosystem);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    public String getValue() {
        return "This is a test";
    }
}
