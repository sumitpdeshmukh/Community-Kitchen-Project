/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author Sumit
 */
public class PersonDirectory {
    
    private ArrayList<Person> partcipantList;

    public PersonDirectory() {
        partcipantList = new ArrayList<>();
    }

    public ArrayList<Person> getPartcipantList() {
        return partcipantList;
    }
    
    public Person createParticipant(String name){
        Person participant = new Person();
        participant.setName(name);
        partcipantList.add(participant);
        return participant;
    }
    
    public void removeParticipant(Person participant) {
        partcipantList.remove(participant);
    }
}