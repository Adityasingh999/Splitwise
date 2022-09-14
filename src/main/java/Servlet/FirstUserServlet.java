package Servlet;

import UserFactory.UserInstanceFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.FirstUser;
import web.UserManager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FirstUserServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private UserManager userManager = UserInstanceFactory.getUserManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //TODO Get Persistance type from request or configuration/ property file or environment
        List<FirstUser> users = userManager.Userslist();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users));
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FirstUser user1 = objectMapper.readValue(request.getReader(), FirstUser.class);
        try {
            userManager.addUser(user1);
        }
        catch (Exception e) {
            response.setStatus(500);
            response.getWriter().write("Internal server error");
        }
    }

    /*@Override
    protected final void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            userManager.deleteUser(Integer.valueOf(req.getParameter("Id")));
        }catch (Exception e) {
            resp.setStatus(500);
            resp.getWriter().write("Internal server error");
        }
    }*/
    /*@Override
    protected void doPut (HttpServletRequest request, HttpServletResponse response) throws IOException {
        //TODO Get Persistance type from request or configuration/ property file or environment
        FirstUser user1 = objectMapper.readValue(request.getReader(), FirstUser.class);
        try {
            userManager.updateUser(user1);
        }
        catch (Exception e) {
            response.setStatus(500);
            response.getWriter().write("Internal server error");
        }
    }*/

}
