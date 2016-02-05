/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import java.io.IOException;
import java.util.HashMap;
import wrapper.OAuth2EmailSendWrapper;

/**
 *
 * @author sumit
 */
public class OAuth2FetchTokens {
    private static OAuth2EmailSendWrapper wrapper;
    private static final String client_id = "116117908677-c0sjsb7br5el2itgf77tvnci9hcm073d.apps.googleusercontent.com";
    private static final String client_secret = "8BWjSWy22jbWyOBzvFLnT6xg";
    private static final String redirect_url = "urn:ietf:wg:oauth:2.0:oob:auto";
    private String access_token = "";
    private String refresh_token = "";
    HashMap<String, String> accessMap;
    
    public OAuth2FetchTokens() {
        accessMap = new HashMap<>();
    }
    
    public static void setWrapper(OAuth2EmailSendWrapper wrapper) {
        OAuth2FetchTokens.wrapper = wrapper;
    }
    
    public void preapreAccessToken(String oAuthToken) throws IOException {
        try {
            GoogleTokenResponse response
                    = new GoogleAuthorizationCodeTokenRequest(new NetHttpTransport(),
                            new JacksonFactory(),client_id, client_secret,
                            oAuthToken, redirect_url)
                    .execute();
            access_token = response.getAccessToken();
            refresh_token = response.getRefreshToken();
            System.out.println("Access token: " + access_token);
            System.out.println("Refresh token: " + refresh_token);
            if (accessMap.containsKey(wrapper.getSenderMail())) {
                accessMap.remove(wrapper.getSenderMail());
            }
            accessMap.put(wrapper.getSenderMail(), access_token);
        } catch (TokenResponseException e) {
            if (e.getDetails() != null) {
                System.err.println("Error: " + e.getDetails().getError());
                if (e.getDetails().getErrorDescription() != null) {
                    System.err.println(e.getDetails().getErrorDescription());
                }
                if (e.getDetails().getErrorUri() != null) {
                    System.err.println(e.getDetails().getErrorUri());
                }
            } else {
                System.err.println(e.getMessage());
            }
        }
    }
    
    public String prepareURL() {
        String url = "https://accounts.google.com/o/oauth2/auth?";
        String urlParameters = "response_type=code"
                + "&client_id=" + client_id + "&redirect_uri=" + redirect_url
                + "&scope=https://mail.google.com/" 
                + "&login_hint=" + /*wrapper.getSenderMail() + */ "&false";
        
        return url + urlParameters;
    }

    public String getAccess_token(String email) {
        if (accessMap.containsKey(email)) {
            return accessMap.get(email);
        } else {
            return "";
        }
    }

    public String getRefresh_token() {
        return refresh_token;
    } 

}
