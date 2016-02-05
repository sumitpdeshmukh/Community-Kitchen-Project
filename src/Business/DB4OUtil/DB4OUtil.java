/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DB4OUtil;

import Business.ConfigureASystem;
import Business.KitchenSystem;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;

/**
 *
 * @author Sumit
 */
public class DB4OUtil {
    private static final String FILENAME = "ProjectDataBank.db4o";
    private static DB4OUtil db4OUtil;
    
    
    public synchronized static DB4OUtil getInstance() {
        if(db4OUtil == null) {
            db4OUtil = new DB4OUtil();
        }
        return db4OUtil;
    }
    
    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
        
    }
    
    private ObjectContainer createConnection() {
        try {
            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            config.common().activationDepth(Integer.MAX_VALUE);
            config.common().updateDepth(Integer.MAX_VALUE);
            config.common().objectClass(KitchenSystem.class).cascadeOnUpdate(true);
            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
            return db;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    public synchronized void storeSystem(KitchenSystem system) {
        ObjectContainer conn = createConnection();
        conn.store(system);
        conn.commit();
        conn.close();
    }
    
    public KitchenSystem retrieveSystem() {
        ObjectContainer conn = createConnection();
        ObjectSet<KitchenSystem> systems = conn.query(KitchenSystem.class);
        KitchenSystem system;
        
        if(systems.size() == 0) {
            system = ConfigureASystem.configure();
        } else {
            system = systems.get(systems.size() - 1);
        }
        conn.close();
        return system;
    }
}
