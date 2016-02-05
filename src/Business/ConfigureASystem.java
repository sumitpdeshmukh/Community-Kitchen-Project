package Business;

import Business.Person.Person;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Sumit
 */
public class ConfigureASystem {
    
    public static KitchenSystem configure(){
        
        KitchenSystem system = KitchenSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some Participants 
        //create user account
        
        
        Person participant = system.getParticipantList().createParticipant("Scott Tiger");
        
        UserAccount ua = system.getUserAccountList().createUserAccount("sysadmin", "sysadmin",
                participant, new SystemAdminRole());
        
        participant.setDesignation("System Admin");
        
        return system;
    }
    
}
