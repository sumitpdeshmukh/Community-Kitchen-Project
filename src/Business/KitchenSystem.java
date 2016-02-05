/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Sumit
 */
public class KitchenSystem extends Organization{
    private static KitchenSystem business;
    private ArrayList<Network> networklist;

    private KitchenSystem() {
        super(null);
        networklist = new ArrayList<>();
    }
    
    static KitchenSystem getInstance() {
        if(business == null) {
            business = new KitchenSystem();
        }
        
        return business;
    }

    public ArrayList<Network> getNetworkList() {
        return networklist;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    
    public boolean checkIfUserNameIsUnique(String userName) {
        return this.getUserAccountList().checkIfUsernameIsUnique(userName);
    }
    
    public Network createNetwork() {
        Network network = new Network();
        networklist.add(network);
        return network;
    }
}
