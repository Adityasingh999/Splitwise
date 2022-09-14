package Database;

import models.FirstUser;
import web.UserManager;

public class Main {
    private static DatabaseUserManager databaseUserManager=new DatabaseUserManager();
    public static void main(String[] args){

        System.out.println(databaseUserManager.addUser(new FirstUser(1000,4,0)));
    }
}
