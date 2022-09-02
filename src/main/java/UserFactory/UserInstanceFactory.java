package UserFactory;

import Database.DatabaseUserManager;
import web.UserManager;

import java.util.HashMap;
import java.util.Map;

public class UserInstanceFactory {

    private static Map<PersistenceType, UserManager> instanceMap = new HashMap<>();

    private static final PersistenceType persistenceType = PersistenceType.valueOf(System.getProperty("persistenceImplementation", PersistenceType.DB.name()));

    public static UserManager getUserManager() {
        UserManager userManager = instanceMap.get(persistenceType);
        if(userManager == null) {
            synchronized (UserInstanceFactory.class) {
                userManager = instanceMap.get(persistenceType);
                if(userManager == null) {
                    switch (persistenceType) {
                        case DB:
                            userManager = new DatabaseUserManager();
                            instanceMap.put(persistenceType, new DatabaseUserManager());
                            break;
                    }
                }
            }
        }
        return userManager;
    }
}
