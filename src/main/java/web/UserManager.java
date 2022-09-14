package web;

import models.FirstUser;

import java.util.List;

public interface UserManager {
    public List<FirstUser> Userslist();
    public int addUser(FirstUser user);


}
