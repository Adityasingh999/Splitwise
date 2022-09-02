package web;

import models.FirstUser;
import models.User;

import java.util.List;

public interface UserManager {
    int addUser(FirstUser user1);
    void updateUser(FirstUser user);
    List<User> listUsers();
    void deleteUser(int id);
    List<User> searchUsers(String keyword);
    public List<FirstUser> Userslist();
    public int addUser(User user);

}
