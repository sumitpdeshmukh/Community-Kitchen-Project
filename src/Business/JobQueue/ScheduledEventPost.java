/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.JobQueue;

import Business.MenuDishes.MenuTypeCatalog;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Sumit
 */
public class ScheduledEventPost extends JobRequest{
    
    private String scheduledEvent;
    private ArrayList<UserAccount> attendanceList;
    private final MenuTypeCatalog menuList;
    
    public ScheduledEventPost() {
        attendanceList = new ArrayList<>();
        menuList = new MenuTypeCatalog();
    }

    public void addAttendingUser(UserAccount ua) {
        attendanceList.add(ua);
    }
    
    public void deleteAttendingUser(UserAccount ua) {
        attendanceList.remove(ua);
    }

    public ArrayList<UserAccount> getAttendanceList() {
        return attendanceList;
    }
    
    
    public String getScheduledEvent() {
        return scheduledEvent;
    }

    public void setScheduledEvent(String scheduledEvent) {
        this.scheduledEvent = scheduledEvent;
    }

    public MenuTypeCatalog getMenuList() {
        return menuList;
    }
    
    @Override
    public String toString() {
        return scheduledEvent;
    }
    
    
}
