/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MenuDishes;

/**
 *
 * @author sumit
 */
public class MenuType {
    private String foodType;
    private MenuDishCatalog catalog;

     
    public MenuDishCatalog getCatalog() {
        return catalog;
    }
   
    public MenuType() {
        catalog = new MenuDishCatalog();
    }

    
    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return foodType;
    }
    
    
}
