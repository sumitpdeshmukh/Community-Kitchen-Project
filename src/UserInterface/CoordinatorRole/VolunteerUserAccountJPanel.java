/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CoordinatorRole;

import Business.Enterprise.KitchenEnterprise;
import Business.Organization.VolunteerOrganization;
import Business.Person.Person;
import Business.Role.VolunteerRole;
import Business.UserAccount.UserAccount;
import Validator.MyStringInputVerifier;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.events.TitleEvent;
import com.teamdev.jxbrowser.chromium.events.TitleListener;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import wrapper.OAuth2EmailSendWrapper;

/**
 *
 * @author Administrator
 */
public class VolunteerUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    private JPanel container;
    private VolunteerOrganization volunteer;
    private static final OAuth2EmailSendWrapper wrapper = OAuth2EmailSendWrapper.getInstance();
    private final KitchenEnterprise enterprise;
    private final UserAccount userAccount;
    public VolunteerUserAccountJPanel(JPanel container, VolunteerOrganization volunteer, 
            KitchenEnterprise enterprise, UserAccount ua) {
        initComponents();
        this.volunteer = volunteer;
        this.container = container;
        this.enterprise = enterprise;
        this.userAccount = ua;
        txtUsername.setInputVerifier(new MyStringInputVerifier());
        txtPassword.setInputVerifier(new MyStringInputVerifier());
        populateData();
    }

    public void populateData() {
        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
        model.setRowCount(0);

        for (Person participant : volunteer.getParticipantList().getPartcipantList()) {
            Object row[] = new Object[4];
            row[0] = participant;
            row[1] = participant.getCity();
            for (UserAccount ua : volunteer.getUserAccountList().getUserAccountList()) {
                if (ua.getParticipant().equals(participant)) {
                    row[2] = ua.getUsername();
                    row[3] = ua.getRole();
                }
            }            
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

        btnCreate = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnDelVol = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btnCreate.setBackground(new java.awt.Color(255, 255, 204));
        btnCreate.setText("Create & Mail Credentials");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        txtUsername.setBackground(new java.awt.Color(255, 255, 204));

        lblUsername.setText("User Name");

        tblUser.setBackground(new java.awt.Color(255, 255, 204));
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Participant Name", "Participant City", "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUser);
        if (tblUser.getColumnModel().getColumnCount() > 0) {
            tblUser.getColumnModel().getColumn(2).setResizable(false);
            tblUser.getColumnModel().getColumn(3).setResizable(false);
        }

        lblPassword.setText("Password");

        txtPassword.setBackground(new java.awt.Color(255, 255, 204));

        btnBack.setBackground(new java.awt.Color(255, 255, 204));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Manage Volunteer User Account");

        btnDelVol.setBackground(new java.awt.Color(255, 255, 204));
        btnDelVol.setText("Disregard");
        btnDelVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelVolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreate))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUsername)
                                    .addComponent(lblPassword))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(88, 88, 88)
                        .addComponent(btnDelVol)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername)
                    .addComponent(btnDelVol))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnCreate)))
                .addContainerGap(166, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String userName = txtUsername.getText();
        String password = txtPassword.getText();
        if (userName.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No Username or password is entered",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int selected_row = tblUser.getSelectedRow();
        if (selected_row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a volunteer from table",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }        

        if (!volunteer.getUserAccountList().checkIfUsernameIsUnique(userName)) {
            JOptionPane.showMessageDialog(this, "Username: " + userName + " is not available. Choose Different name",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Person person = (Person)tblUser.getValueAt(selected_row, 0);        
        
        volunteer.getUserAccountList().createUserAccount(userName, password, person, new VolunteerRole());
              
        populateData();
        
        wrapper.setSenderMail(userAccount.getParticipant().getEmailID());
        wrapper.setSubject("Welcome to " + enterprise.getName());
        wrapper.setMessageContent("Hi " + person.getName() + ",\n" + "Your Username: " + userName + 
                "\n" + "Your Password: " + password + "\n\nRegards, \nCoordinator " + enterprise.getName() + ",\n"
        + userAccount.getParticipant().getName());
        String email = person.getEmailID();
        wrapper.getDirectRecipientList().add(email);
        String token = wrapper.getAccess_token(userAccount.getParticipant().getEmailID());
        if (token.equalsIgnoreCase("")) {
            prepareAuthetication();
        } else {
            sendEmail();
        }
        resetFields();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void sendEmail() {
        if (wrapper.initializeConnection()) {
            wrapper.SendEmail();
            JOptionPane.showMessageDialog(this, "Message Sent successfully", "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to connect and send email", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDelVolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelVolActionPerformed
        // TODO add your handling code here:
        int selected_row = tblUser.getSelectedRow();
        if (selected_row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a volunteer from table",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Person person = (Person) tblUser.getValueAt(selected_row, 0);
        int dialog_result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + person.getName()
                + " ?","Warning", JOptionPane.YES_NO_OPTION);
        
        if (dialog_result == JOptionPane.YES_OPTION) {
            volunteer.getParticipantList().removeParticipant(person);
            populateData();
            JOptionPane.showMessageDialog(this, "Person disregarded successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDelVolActionPerformed

    private void resetFields() {
        txtUsername.setText("");
        txtPassword.setText("");
    }
    
    private void prepareAuthetication() {
        Browser browser = new Browser();

        BrowserView browserView = new BrowserView(browser);

        JFrame frame = new JFrame();

        frame.add(browserView, BorderLayout.CENTER);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //wrapper.setSenderMail(txtFrom.getText());

        browser.addTitleListener(new TitleListener() {
            @Override
            public void onTitleChange(TitleEvent event) {
                String client_auth = event.getTitle();
                System.out.println("Title = " + client_auth);
                if (!client_auth.equalsIgnoreCase("Request for Permission")) {
                    if (!client_auth.equalsIgnoreCase("Sign in - Google Accounts")) {

                        client_auth = client_auth.substring(13, client_auth.length());
                        try {
                            wrapper.preapreAccessToken(client_auth);
                            sendEmail();
                        } catch (Exception e) {

                        }
                    }
                }

            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                browser.getCookieStorage().deleteAll();
                browser.getCacheStorage().clearCache();
                browser.dispose();
            }
        });

        browser.loadURL(wrapper.getMailServerUrl());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelVol;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
