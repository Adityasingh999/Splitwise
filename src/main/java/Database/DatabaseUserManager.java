package Database;
import models.FirstUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.UserManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseUserManager implements UserManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseUserManager.class);


        /*List<User> userList = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnectionNonSingleTon();

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USER");
            while(resultSet.next()) {// points to Row ON each iteration
                //ID, NAME, AGE, EmployeeD
                int Id= resultSet.getInt("id");
                String Name = resultSet.getString("name");
                long phonenumber = resultSet.getInt("phonenumber");
                String email = resultSet.getString("email");
                int expense=resultSet.getInt("expense");
                userList.add(new User(Id,Name,phonenumber,email,expense));
                LOGGER.info("Employee list is {}", userList);
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return userList;
    }*/
    public List<FirstUser> Userslist() {
        List<FirstUser> userList = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnectionNonSingleTon();

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM firstuser");
            while(resultSet.next()) {// points to Row ON each iteration
                //ID, NAME, AGE, EmployeeD

                int expense=resultSet.getInt("expense");
                int count=resultSet.getInt("count");
                int paidto= resultSet.getInt("paidto");

                userList.add(new FirstUser(count,expense,paidto));
                LOGGER.info("Employee list is {}", userList);
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return userList;
    }
        //TDOO
        /*Connection connection = DatabaseConnection.getConnectionNonSingleTon();
        try {
            String sql = "INSERT INTO  USER(id, name,phonenumber,email,expense) VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setLong(3, user.getPhonenumber());
            statement.setString(4, user.getEmail());
            statement.setInt(5,user.getExpense());



            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                LOGGER.info("New employee {} added successfully", user);
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
        finally {
            DatabaseConnection.closeConnection(connection);
        }
        return user.getId();
    }*/

    public int addUser(FirstUser user) {
        //TDOO
        Connection connection = DatabaseConnection.getConnectionNonSingleTon();
        try {
            String sql = "INSERT INTO  firstuser(expense,count,paidto) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);


            statement.setInt(1,user.getExpense());
            statement.setInt(2,user.getCount());
            statement.setInt(3,user.getPaidto());



            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                LOGGER.info("New employee {} added successfully", user);
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
        finally {
            DatabaseConnection.closeConnection(connection);
        }
        return user.getPaidto();
    }


    /*public void deleteUser(int Id) {
        Connection connection = DatabaseConnection.getConnectionNonSingleTon();
        try {
            String sql = "DELETE FROM firstuser WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Id);

            int rowsDeleted = statement.executeUpdate();


            if (rowsDeleted > 0) {
                System.out.println("An Employee was deleted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
        finally {
            DatabaseConnection.closeConnection(connection);
        }
    }*/

    /*@Override
    public List<User> searchUsers(String keyword) {
        return null;
    }*/

    /*public void updateUser(FirstUser user){
        Connection connection = DatabaseConnection.getConnectionNonSingleTon();
        try {
            String sql = "UPDATE firstuser SET paidto=? WHERE expense=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            int amount=user.getExpense()/user.getCount();
            statement.setInt(1,amount);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Employee was updated successfully!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DatabaseConnection.closeConnection(connection);
        }





    }*/


}

