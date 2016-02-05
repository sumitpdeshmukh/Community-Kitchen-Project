/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MenuDishes;

import java.util.ArrayList;

/**
 *
 * @author sumit
 */
public class MenuDishCatalog {

    private ArrayList<MenuDish> dishList;
    
    public enum DishType{
        Veg("Vegetarian"), 
        NonVeg("Non-Vegetarian"),
        vegan("Vegan");
        private String value;
        private DishType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public MenuDishCatalog() {
        dishList = new ArrayList<>();
    }

    public ArrayList<MenuDish> getDishList() {
        return dishList;
    }

    public MenuDish AddItemtoMenu() {
        MenuDish item = new MenuDish();
        dishList.add(item);
        return item;
    }
    
    public void removeDish(MenuDish item) {
        dishList.remove(item);
    }
}
