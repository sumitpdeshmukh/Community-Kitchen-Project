/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

/**
 *
 * @author sumit
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyTableCellRenderer
       extends DefaultTableCellRenderer {
    private final int SPECIAL_COULMN = 1;
    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 boolean hasFocus,
                                                 int row,
                                                 int column) {
    Component c = 
      super.getTableCellRendererComponent(table, value,
                                          isSelected, hasFocus,
                                          row, column);

    // Only for specific cell
    float val = (Float) value;
    if (val < 1) {
        if (column == SPECIAL_COULMN) {
           c.setForeground(Color.RED);
        } else {
            //c.setForeground(Color.BLACK);
            c.setForeground(null);
        }
    }
    return c;
  }
}
