/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.Enterprise.Enterprise;
import Business.KitchenSystem;
import Business.Network.Network;
import Business.Organization.Organization;
import UserInterface.SystemAdminWorkArea.ManageEnterpriseAdminJPanel;
import UserInterface.SystemAdminWorkArea.ManageEnterpriseJPanel;
import UserInterface.SystemAdminWorkArea.ManageNetworkJPanel;
import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Sumit
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    private final JPanel userProcessContainer;
    private final KitchenSystem system;
    public SystemAdminWorkAreaJPanel(JPanel upc, KitchenSystem ecosystem) {
        initComponents();
        this.userProcessContainer = upc;
        this.system = ecosystem;
        DisplayImage();
        populateTree();
    }

    private void DisplayImage() {
        try {
            BufferedImage img=ImageIO.read(new File("resources\\Kitchens.JPG"));
            ImageIcon icon=new ImageIcon(img);
            lblicon.setIcon(icon);   
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void populateTree() {
        DefaultTreeModel model = (DefaultTreeModel) treeKitchenSystem.getModel();
        ArrayList<Network> networklist = system.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        Network network;
        Organization organization;
        Enterprise enterprise;

        DefaultMutableTreeNode networks = new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);

        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;

        for (int i = 0; i < networklist.size(); i++) {
            network = networklist.get(i);
            networkNode = new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);

            enterpriseList = network.getEnterpriseList().getEnterpriseList();
            for (int j = 0; j < enterpriseList.size(); j++) {
                enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);

                organizationList = enterprise.getOrganizationList().getOrganizationList();
                for (int k = 0; k < organizationList.size(); k++) {
                    organization = organizationList.get(k);
                    organizationNode = new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }

        }
        model.reload();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        navPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeKitchenSystem = new javax.swing.JTree();
        workAreaPanel = new javax.swing.JPanel();
        lblMode = new javax.swing.JLabel();
        btnManageNetwork = new javax.swing.JButton();
        btnManageEnterprise = new javax.swing.JButton();
        btnManageAdmin = new javax.swing.JButton();
        lblSelectedNode = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblicon = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jSplitPane.setDividerLocation(225);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Community Kitchen");
        treeKitchenSystem.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeKitchenSystem.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeKitchenSystemValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(treeKitchenSystem);

        javax.swing.GroupLayout navPanelLayout = new javax.swing.GroupLayout(navPanel);
        navPanel.setLayout(navPanelLayout);
        navPanelLayout.setHorizontalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
        );
        navPanelLayout.setVerticalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane.setLeftComponent(navPanel);

        workAreaPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblMode.setBackground(new java.awt.Color(160, 39, 44));
        lblMode.setForeground(new java.awt.Color(153, 0, 0));
        lblMode.setText("Selected Mode");

        btnManageNetwork.setBackground(new java.awt.Color(153, 0, 0));
        btnManageNetwork.setForeground(new java.awt.Color(255, 255, 255));
        btnManageNetwork.setText("Manage Network Kitchens");
        btnManageNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageNetworkActionPerformed(evt);
            }
        });

        btnManageEnterprise.setBackground(new java.awt.Color(153, 0, 0));
        btnManageEnterprise.setForeground(new java.awt.Color(255, 255, 255));
        btnManageEnterprise.setText("Manage Kitchens");
        btnManageEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEnterpriseActionPerformed(evt);
            }
        });

        btnManageAdmin.setBackground(new java.awt.Color(153, 0, 0));
        btnManageAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnManageAdmin.setText("Manage Kitchen Admin");
        btnManageAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageAdminActionPerformed(evt);
            }
        });

        lblSelectedNode.setForeground(new java.awt.Color(153, 0, 0));
        lblSelectedNode.setText("<<>>");

        jLabel1.setBackground(new java.awt.Color(160, 39, 44));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("System Admin Work Area");

        lblicon.setBackground(new java.awt.Color(255, 255, 255));
        lblicon.setText("jLabel1");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout workAreaPanelLayout = new javax.swing.GroupLayout(workAreaPanel);
        workAreaPanel.setLayout(workAreaPanelLayout);
        workAreaPanelLayout.setHorizontalGroup(
            workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workAreaPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnManageAdmin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnManageNetwork, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addComponent(btnManageEnterprise, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(workAreaPanelLayout.createSequentialGroup()
                        .addComponent(lblMode)
                        .addGap(39, 39, 39)
                        .addComponent(lblSelectedNode, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblicon, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        workAreaPanelLayout.setVerticalGroup(
            workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workAreaPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(workAreaPanelLayout.createSequentialGroup()
                        .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblicon, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(workAreaPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(workAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMode)
                                    .addComponent(lblSelectedNode))
                                .addGap(33, 33, 33)
                                .addComponent(btnManageNetwork)
                                .addGap(29, 29, 29)
                                .addComponent(btnManageEnterprise)
                                .addGap(36, 36, 36)
                                .addComponent(btnManageAdmin)))
                        .addGap(0, 122, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jSplitPane.setRightComponent(workAreaPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void treeKitchenSystemValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeKitchenSystemValueChanged
        // TODO add your handling code here:
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeKitchenSystem.getLastSelectedPathComponent();
        if (selectedNode != null) {
            lblSelectedNode.setText(selectedNode.toString());
        }
        treeKitchenSystem.scrollPathToVisible(treeKitchenSystem.getSelectionPath());
    }//GEN-LAST:event_treeKitchenSystemValueChanged

    private void btnManageNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageNetworkActionPerformed
        // TODO add your handling code here:
        ManageNetworkJPanel panel = new ManageNetworkJPanel(userProcessContainer, system);
        userProcessContainer.add("ManageNetworkJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageNetworkActionPerformed

    private void btnManageEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEnterpriseActionPerformed
        // TODO add your handling code here:
        ManageEnterpriseJPanel panel = new ManageEnterpriseJPanel(userProcessContainer, system);
        userProcessContainer.add("ManageEnterpriseJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageEnterpriseActionPerformed

    private void btnManageAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageAdminActionPerformed
        // TODO add your handling code here:
        ManageEnterpriseAdminJPanel panel = new ManageEnterpriseAdminJPanel(userProcessContainer, system);
        userProcessContainer.add("ManageEnterpriseAdminJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageAdminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageAdmin;
    private javax.swing.JButton btnManageEnterprise;
    private javax.swing.JButton btnManageNetwork;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JLabel lblMode;
    private javax.swing.JLabel lblSelectedNode;
    private javax.swing.JLabel lblicon;
    private javax.swing.JPanel navPanel;
    private javax.swing.JTree treeKitchenSystem;
    private javax.swing.JPanel workAreaPanel;
    // End of variables declaration//GEN-END:variables
}
