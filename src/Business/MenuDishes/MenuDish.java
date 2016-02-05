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
public class MenuDish {
    private String dishName;
    private String dishType;
    private String dishTaste;
    private static int count = 0;    
    private String dishDescription;
    private int dishID;
    public MenuDish() {
        dishID = ++count;
    }

    public int getDishID() {
        return dishID;
    }
       
    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    public String getDishTaste() {
        return dishTaste;
    }

    public void setDishTaste(String dishTaste) {
        this.dishTaste = dishTaste;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }
    
    @Override
    public String toString() {
        return dishName;
    }
    
    
}
