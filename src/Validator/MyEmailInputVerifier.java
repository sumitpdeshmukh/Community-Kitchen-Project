/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Sumit
 */
public class MyEmailInputVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent textBox) {
        JTextField tf = (JTextField) textBox;
        String str = tf.getText();
        if (str.trim().isEmpty()) {
            JOptionPane.showMessageDialog(textBox.getParent(), "Mandatory field and cannot contain only white spaces.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try {
           if(str.contains("@") && str.contains(".")) {
               int index = str.indexOf("@");
               if (index >= 1 && index == str.lastIndexOf("@")) {
                   return true;
               } else if(str.contains(";") || str.contains(",")) {
                   return true;
               }
           }
        } catch (Exception e) {
                        
        }
        JOptionPane.showMessageDialog(textBox.getParent(), "Please add correct Email Address", "Warning", JOptionPane.WARNING_MESSAGE);
        return false;
    }
}
