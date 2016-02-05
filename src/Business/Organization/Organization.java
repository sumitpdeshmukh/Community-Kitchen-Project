/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.JobQueue.JobQueue;
import Business.Person.PersonDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author Sumit
 */
public abstract class Organization {
    private String name;
    private JobQueue jobQueue;
    private final UserAccountDirectory userAccountList;
    private final int organizationID;
    private final PersonDirectory participantList;
    private static int counter;
    
    public enum Type{
        Admin("Admin Organization"), 
        Supplier("Supplier Organization"),
        Volunteer("Volunteer Organization"),
        Chef("Chef Organization"),
        Coordinator("Coordinator Organization");
        private final String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Organization(String name) {
        this.name = name;
        jobQueue = new JobQueue();
        participantList = new PersonDirectory();
        userAccountList = new UserAccountDirectory();
        organizationID = counter++;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountList() {
        return userAccountList;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public PersonDirectory getParticipantList() {
        return participantList;
    }
    
    public String getName() {
        return name;
    }

    public JobQueue getJobQueue() {
        return jobQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJobQueue(JobQueue jobQueue) {
        this.jobQueue = jobQueue;
    }

    
        
    @Override
    public String toString() {
        return name;
    }

  
    
}
