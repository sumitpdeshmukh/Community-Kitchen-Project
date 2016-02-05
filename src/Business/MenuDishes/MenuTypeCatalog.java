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
public class MenuTypeCatalog {

    private ArrayList<MenuType> menuList;

//    public enum FoodType{
//        Indian("Indian"), 
//        American("American"),
//        Mexican("Mexican"),
//        Chinese("Chinese"),
//        Italian("Italian"),
//        Mediterranian("Mediterranian"),
//        Continental("Continental");
//        private String value;
//        private FoodType(String value) {
//            this.value = value;
//        }
//        public String getValue() {
//            return value;
//        }
//    }
    public MenuTypeCatalog() {
        menuList = new ArrayList<>();
    }

    public ArrayList<MenuType> getMenuList() {
        return menuList;
    }

    public MenuType AddItemtoMenuType() {
        MenuType type = new MenuType();
        menuList.add(type);
        return type;
    }
}
