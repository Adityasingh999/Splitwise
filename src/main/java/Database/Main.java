package Database;

import models.FirstUser;
import web.UserManager;

public class Main {
    private static DatabaseUserManager databaseUserManager=new DatabaseUserManager();
    public static void main(String[] args){

        System.out.println(databaseUserManager.addUser(new FirstUser(3,"abc",99,"aabc",2,2,1,25)));
    }
}
