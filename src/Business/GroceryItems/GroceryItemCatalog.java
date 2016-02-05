/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.GroceryItems;

import java.util.ArrayList;

/**
 *
 * @author sumit
 */
public class GroceryItemCatalog {

    private ArrayList<GroceryItem> itemList;
    
    public GroceryItemCatalog() {
        itemList = new ArrayList<>();
    }

    public ArrayList<GroceryItem> getItemList() {
        return itemList;
    }

    public GroceryItem AddItemtoGrocery() {
        GroceryItem item = new GroceryItem();
        itemList.add(item);
        return item;
    }
    
    public void RemoveGroceryItem(GroceryItem item) {
        itemList.remove(item);
    }
    
    public void RemoveAllItem() {
        itemList.clear();
    }
}
