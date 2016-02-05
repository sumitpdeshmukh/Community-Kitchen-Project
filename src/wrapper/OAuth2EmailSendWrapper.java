/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrapper;

import java.util.ArrayList;
import lib.OAuth2Authenticator;
import lib.OAuth2FetchTokens;



public class OAuth2EmailSendWrapper {
    private String subject;
    private final ArrayList<String> directRecipientList;
    private final ArrayList<String> copyRecipientList;
    private final ArrayList<String> blindCopyRecipientList;
    private String messageContent;
    private String senderMail;
    private static OAuth2EmailSendWrapper wrapper;
    
    private final OAuth2Authenticator authenticator;//= OAuth2Authenticator.getInstance();
    
    private final OAuth2FetchTokens tokens;

    public static OAuth2EmailSendWrapper getInstance() {
        if (wrapper == null) {
            wrapper = new OAuth2EmailSendWrapper();
        }
        OAuth2Authenticator.setWrapper(wrapper);
        OAuth2FetchTokens.setWrapper(wrapper);
        return wrapper;
    }
    
    public OAuth2EmailSendWrapper() {
        directRecipientList = new ArrayList<>();
        copyRecipientList = new ArrayList<>();
        blindCopyRecipientList = new ArrayList<>();
        authenticator = new OAuth2Authenticator();
        tokens = new OAuth2FetchTokens();
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getMessageContent() {
        return this.messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getSubject() {
        return this.subject;
    }

    public ArrayList<String> getDirectRecipientList() {
        return directRecipientList;
    }

    public ArrayList<String> getCopyRecipientList() {
        return copyRecipientList;
    }

    public ArrayList<String> getBlindCopyRecipientList() {
        return blindCopyRecipientList;
    }

    public String getSenderMail() {
        return this.senderMail;
    }

    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }  
    
    public boolean initializeConnection() {        
        return authenticator.initializeConnection();      
    }
    
    public void SendEmail() {
        try {
            authenticator.sendEmail();
        } catch (Exception e) {
            System.out.println("Failed to send email");
        }
        
    }
    
    public String getMailServerUrl() {
        return tokens.prepareURL();
    }
    
    public void preapreAccessToken(String oAuthToken) {
        try {
            tokens.preapreAccessToken(oAuthToken);
        } catch (Exception e) {
            System.out.println("Failed to access tokens");
        }        
    }
    
    public String getAccess_token(String email) {
        return tokens.getAccess_token(email);
    }

    public String getRefresh_token() {
        return tokens.getRefresh_token();
    }
    
    public void clearAllMailList() {
        directRecipientList.clear();
        copyRecipientList.clear();
        blindCopyRecipientList.clear();
    }
}
