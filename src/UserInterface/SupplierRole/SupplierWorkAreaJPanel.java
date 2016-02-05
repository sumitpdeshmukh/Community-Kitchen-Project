/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SupplierRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.KitchenEnterprise;
import Business.GroceryItems.GroceryItem;
import Business.Organization.SupplierOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.ComposeEmailJPanel;
import Validator.MyTableCellRenderer;
import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author sumit
 */
public class SupplierWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ChefWorkAreaJPanel
     */
    private final JPanel userProcessContainer;
    private final UserAccount userAccount;
    private final SupplierOrganization supplierOrg;
    private final KitchenEnterprise enterprise;
    public SupplierWorkAreaJPanel(JPanel upc, UserAccount ua, SupplierOrganization org, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = upc;
        this.userAccount = ua;
        this.supplierOrg = org;
        this.enterprise = (KitchenEnterprise)enterprise;
        populateTable();
        lblVolName.setText(ua.getParticipant().getName());
        DisplayImage();
    }

    private void DisplayImage() {
        try {
            BufferedImage img=ImageIO.read(new File("resources\\image2.jpg"));
            ImageIcon icon=new ImageIcon(img);
            jLabel2.setIcon(icon);   
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblGrocery.getModel();
        model.setRowCount(0);
        tblGrocery.setDefaultRenderer(Float.class, new MyTableCellRenderer());
        for (GroceryItem item : enterprise.getGroceryList().getItemList()) {
             Object row[] = new Object[4];
             row[0] = item;
             row[1] = item.getQuantity();
             row[2] = item.getContainerCap();
             row[3] = item.getItemNote();
             model.addRow(row);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblGrocery = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblVolName = new javax.swing.JLabel();
        btnManageSupplies = new javax.swing.JButton();
        btnSendEmail = new javax.swing.JButton();
        btnGetSuppliesInfo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblGrocery.setBackground(new java.awt.Color(255, 255, 204));
        tblGrocery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grocery Name", "Grocery Qty. (lbs/ltr)", "Container Capacity(lbs/ltr)", "Grocery Description"
            }
        ));
        jScrollPane1.setViewportView(tblGrocery);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Supplier:");

        lblVolName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblVolName.setText("<<WelCome >>");

        btnManageSupplies.setBackground(new java.awt.Color(255, 255, 204));
        btnManageSupplies.setText("Manage Supplies");
        btnManageSupplies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageSuppliesActionPerformed(evt);
            }
        });

        btnSendEmail.setBackground(new java.awt.Color(255, 255, 204));
        btnSendEmail.setText("Send Email");
        btnSendEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendEmailActionPerformed(evt);
            }
        });

        btnGetSuppliesInfo.setBackground(new java.awt.Color(255, 255, 204));
        btnGetSuppliesInfo.setText("Get Supplies Info");
        btnGetSuppliesInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetSuppliesInfoActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblVolName))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGetSuppliesInfo)
                            .addComponent(btnManageSupplies)
                            .addComponent(btnSendEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblVolName)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGetSuppliesInfo)
                                .addGap(18, 18, 18)
                                .addComponent(btnManageSupplies)
                                .addGap(18, 18, 18)
                                .addComponent(btnSendEmail)))
                        .addGap(0, 82, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageSuppliesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageSuppliesActionPerformed
        // TODO add your handling code here:
        int row_selected = tblGrocery.getSelectedRow();
        if (row_selected < 0) {
            JOptionPane.showMessageDialog(this, "Please select a grocery Item first.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        ManageSuppliesJPanel supplies = new ManageSuppliesJPanel(userProcessContainer, userAccount,
                (KitchenEnterprise)enterprise, (GroceryItem)tblGrocery.getValueAt(row_selected, 0));
        userProcessContainer.add("ManageSuppliesJPanel", supplies);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnManageSuppliesActionPerformed

    private void btnSendEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendEmailActionPerformed
        // TODO add your handling code here:
        ComposeEmailJPanel frame = new ComposeEmailJPanel(userProcessContainer, userAccount, enterprise);
        userProcessContainer.add("ComposeEmailJPanel", frame);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnSendEmailActionPerformed

    private void btnGetSuppliesInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetSuppliesInfoActionPerformed
        // TODO add your handling code here:
        if (! enterprise.fetchGroceryStockList()) {
            JOptionPane.showMessageDialog(this, "Cannot fetch data file from server ", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (! enterprise.loadFreshGroceryStock()) {
            JOptionPane.showMessageDialog(this, "Failed to load complete Data from xontainers ", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        populateTable();
        JOptionPane.showMessageDialog(this, "Latest Grocery Supplies list is fetched successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnGetSuppliesInfoActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGetSuppliesInfo;
    private javax.swing.JButton btnManageSupplies;
    private javax.swing.JButton btnSendEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblVolName;
    private javax.swing.JTable tblGrocery;
    // End of variables declaration//GEN-END:variables
}
