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
 * @author Sumitsumit
 */
public class MyDigitInputVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent textBox) {
        JTextField tf = (JTextField) textBox;
        String str = tf.getText();
        if (str.trim().isEmpty()) {
            JOptionPane.showMessageDialog(textBox.getParent(), "Mandatory field and cannot contain only white spaces.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try {
            double value = Double.parseDouble(str);
            if (value < 0) {
                JOptionPane.showMessageDialog(textBox.getParent(), "Please add positive values", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(textBox.getParent(), "Please add only Number values", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}
