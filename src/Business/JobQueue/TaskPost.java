/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.JobQueue;

/**
 *
 * @author Sumit
 */
public class TaskPost extends JobRequest{
    
    private String volunteerTask;

    public String getVolunteerTask() {
        return volunteerTask;
    }

    public void setVolunteerTask(String volunteerTask) {
        this.volunteerTask = volunteerTask;
    }

    @Override
    public String toString() {
        return volunteerTask;
    }
    
    
}
