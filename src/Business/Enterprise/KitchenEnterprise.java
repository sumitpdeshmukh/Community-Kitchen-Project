/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.GroceryItems.GroceryItem;
import Business.GroceryItems.GroceryItemCatalog;
import Business.Role.Role;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;

/**
 *
 * @author Sumit
 */
public class KitchenEnterprise extends Enterprise {

    private final GroceryItemCatalog groceryList;
    private final String IOTFile = "//IOTContainerData.csv"; 
    private final String FILENAME = "C:\\data\\Database" + IOTFile;
    public KitchenEnterprise(String name) {
        super(name,EnterpriseType.Kitchen);
        groceryList = new GroceryItemCatalog();
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }  
    
    public GroceryItemCatalog getGroceryList() {
        return groceryList;
    }
    
    public boolean fetchGroceryStockList() {
        
        String urlString = "ftp://mycomkitchen.freetzi.com:sumya28218@mycomkitchen.freetzi.com//IOTDevices"
                + IOTFile + ";type=i";        
        File dir = new File("C:\\Data\\Database");
        if (! dir.exists() && ! dir.isDirectory()) {
            dir.mkdirs();
        }
        boolean result = false;
        try {
            URL url = new URL(urlString);
            URLConnection urlc = url.openConnection();
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            bis = new BufferedInputStream( urlc.getInputStream() );
            bos = new BufferedOutputStream( new FileOutputStream(FILENAME));
                        
            int i;
            while ((i = bis.read()) != -1) {
               bos.write( i );
            }
            
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.flush();
                bos.close();
            }
            result = true;
        } catch (MalformedInputException malformedInputException) {
            malformedInputException.printStackTrace();        
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return result;
    }
    
    public boolean loadFreshGroceryStock() {
        boolean result = false;
        BufferedReader buffer = null;
        getGroceryList().RemoveAllItem();
        try {
            String sCurrentLine;
            buffer = new BufferedReader(new FileReader(FILENAME));
            sCurrentLine = buffer.readLine();
            if (!sCurrentLine.startsWith("Grocery Name")) {
                return result;
            }
            while ((sCurrentLine = buffer.readLine()) != null) {
                 if (!sCurrentLine.trim().isEmpty()) {                     
                        String[] tokens2 = sCurrentLine.split(",");
                        GroceryItem item = getGroceryList().AddItemtoGrocery();
                        int j = 0;
                        for (String tokenY : tokens2) {
                            tokenY = tokenY.trim();
                            if (j == 0) {
                                item.setItemName(tokenY);
                            }
                            if (j == 1) {
                                try {
                                    item.setQuantity(Float.parseFloat(tokenY));
                                } catch (Exception e) {
                                    item.setQuantity(0);
                                }
                            }
                            if (j == 2) {
                                try {
                                    item.setContainerCap(Float.parseFloat(tokenY));
                                } catch (Exception e) {
                                    item.setContainerCap(0);
                                }
                            }
                            if (j == 3) {
                                item.setItemNote(tokenY);
                                result = true;
                                break;
                            }
                            j++;
                        }
                     }
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
