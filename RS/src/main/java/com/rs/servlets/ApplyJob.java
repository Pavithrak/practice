package com.rs.servlets;

import com.rs.core.User;
import com.rs.core.UserRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplyJob extends HttpServlet {
    UserRepository repository;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        repository = new UserRepository();
        User user = repository.authenticate(request.getParameter("user"), request.getParameter("pswd"));
        System.out.println(user);
        getServletConfig().getServletContext().setAttribute("user", user);
        try {
            response.getWriter().print(user.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
