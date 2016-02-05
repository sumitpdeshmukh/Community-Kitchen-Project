/* Copyright 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package lib;

import com.sun.mail.smtp.SMTPTransport;
import java.security.Provider;
import java.security.Security;
import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.URLName;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import wrapper.OAuth2EmailSendWrapper;

/**
 * Performs OAuth2 authentication.
 *
 * <p>
 * Before using this class, you must call {@code initialize} to install the
 * OAuth2 SASL provider.
 */
public class OAuth2Authenticator {
    private static OAuth2EmailSendWrapper wrapper;
    private static final Logger logger
            = Logger.getLogger(OAuth2Authenticator.class.getName());

    public static void setWrapper(OAuth2EmailSendWrapper wrapper) {
        OAuth2Authenticator.wrapper = wrapper;
    }


    public final class OAuth2Provider extends Provider {

        private static final long serialVersionUID = 1L;

        public OAuth2Provider() {
            super("Google OAuth2 Provider", 1.0,
                    "Provides the XOAUTH2 SASL Mechanism");
            put("SaslClientFactory.XOAUTH2",
                    "lib.OAuth2SaslClientFactory");
        }
    }

    /**
     * Installs the OAuth2 SASL provider. This must be called exactly once
     * before calling other methods on this class.
     */
    public void initialize() {
        Security.addProvider(new OAuth2Provider());
    }

    /**
     * Connects and authenticates to an SMTP server with OAuth2. You must have
     * called {@code initialize}.
     *
     * @param host Hostname of the smtp server, for example {@code
     *     smtp.googlemail.com}.
     * @param port Port of the smtp server, for example 587.
     * @param userEmail Email address of the user to authenticate, for example
     * {@code oauth@gmail.com}.
     * @param oauthToken The user's OAuth token.
     * @param debug Whether to enable debug logging on the connection.
     *
     * @return An authenticated SMTPTransport that can be used for SMTP
     * operations.
     */
    public boolean connectToSmtp(String host,int port,String userEmail,String oauthToken) {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.sasl.enable", "true");
        props.put("mail.smtp.sasl.mechanisms", "XOAUTH2");
        props.put(OAuth2SaslClientFactory.OAUTH_TOKEN_PROP, oauthToken);
        try {
            session = Session.getInstance(props);
            session.setDebug(true);
            final URLName unusedUrlName = null;
            transport = new SMTPTransport(session, unusedUrlName);
            // If the password is non-null, SMTP tries to do AUTH LOGIN.
            final String emptyPassword = "";

            transport.connect(host, port, userEmail, emptyPassword);
            return true;
        } catch(Exception ex) {
            return false;
        }
    }
    private static Session session;
    private static SMTPTransport transport;
    //private static OAuth2EmailSendWrapper wrapper = OAuth2EmailSendWrapper.getInstance();

    public boolean initializeConnection() {
        
        String email = wrapper.getSenderMail();
        String oauthToken = wrapper.getAccess_token(email);

        initialize();

        boolean result = connectToSmtp("smtp.gmail.com", 587, email, oauthToken);
       
        return result;
    }

    public void sendEmail() throws AddressException, MessagingException {
        Message msg = new MimeMessage(session);
        Address Adr;
        for (String to : wrapper.getDirectRecipientList()) {
            Adr = new InternetAddress(to);
            msg.addRecipient(Message.RecipientType.TO, Adr);
        }

        for (String cc : wrapper.getCopyRecipientList()) {
            Adr = new InternetAddress(cc);
            msg.addRecipient(Message.RecipientType.CC, Adr);
        }

        for (String bcc : wrapper.getBlindCopyRecipientList()) {
            Adr = new InternetAddress(bcc);
            msg.addRecipient(Message.RecipientType.BCC, Adr);
        }
        msg.setSubject(wrapper.getSubject());
        msg.setText(wrapper.getMessageContent());
        transport.sendMessage(msg, msg.getAllRecipients());
    }
}
