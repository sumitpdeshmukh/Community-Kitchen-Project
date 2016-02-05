/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.JobQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Sumit
 */
public abstract class JobRequest {

    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date taskRequestDate;
    private Date taskAcceptDate;
    private Date taskScheduleDate;
    
    public JobRequest(){
        taskRequestDate = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTaskRequestDate() {
        return taskRequestDate;
    }

    public void setTaskRequestDate(Date taskRequestDate) {
        this.taskRequestDate = taskRequestDate;
    }

    public Date getTaskAcceptDate() {
        return taskAcceptDate;
    }

    public void setTaskAcceptDate(Date taskAcceptDate) {
        this.taskAcceptDate = taskAcceptDate;
    }

    public Date getTaskScheduleDate() {
        return taskScheduleDate;
    }

    public void setTaskScheduleDate(Date taskScheduleDate) {
        this.taskScheduleDate = taskScheduleDate;
    }
}
