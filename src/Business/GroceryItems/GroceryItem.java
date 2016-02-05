/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.GroceryItems;

/**
 *
 * @author sumit
 */
public class GroceryItem {
    private String itemName;
    private float quantity;
    private static int count = 0;
    private int itemContainerID;
    private float rate;
    private float amount;
    private float containerCap;
    private String itemNote;

    public GroceryItem() {
        itemContainerID = ++count;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public int getItemContainerID() {
        return itemContainerID;
    }   

    public String getItemNote() {
        return itemNote;
    }

    public void setItemNote(String itemNote) {
        this.itemNote = itemNote;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    } 

    public float getContainerCap() {
        return containerCap;
    }

    public void setContainerCap(float containerCap) {
        this.containerCap = containerCap;
    }    
    
    @Override
    public String toString() {
        return itemName;
    }
    
    
}
