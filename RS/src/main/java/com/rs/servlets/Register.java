package com.rs.servlets;

import com.rs.core.User;
import com.rs.core.UserRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
    UserRepository repository;

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
      repository = new UserRepository();
        try {
            User user = repository.save(request.getParameter("name"),request.getParameter("email"),request.getParameter("mobile"),request.getParameter("gender"),request.getParameter("experience"),request.getParameter("industry"),request.getParameter("password"));
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
