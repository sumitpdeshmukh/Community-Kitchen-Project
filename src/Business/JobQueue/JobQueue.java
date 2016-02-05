/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.JobQueue;

import java.util.ArrayList;

/**
 *
 * @author Sumit
 */
public class JobQueue {
    
    private ArrayList<JobRequest> jobRequestList;

    public JobQueue() {
        jobRequestList = new ArrayList<>();
    }

    public ArrayList<JobRequest> getJobRequestList() {
        return jobRequestList;
    }
    
    public void deleteJobRequest(JobRequest req) {
        jobRequestList.remove(req);
    }
}