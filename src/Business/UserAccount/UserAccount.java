/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Person.Person;
import Business.Role.Role;
import Business.JobQueue.JobQueue;

/**
 *
 * @author Sumit
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Person participant;
    private Role role;
    private JobQueue jobQueue;

    public UserAccount() {
        jobQueue = new JobQueue();
    }
     
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setParticipant(Person participant) {
        this.participant = participant;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Person getParticipant() {
        return participant;
    }

    public JobQueue getJobQueue() {
        return jobQueue;
    }
 
    @Override
    public String toString() {
        return username;
    }
    
    
    
}