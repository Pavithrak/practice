package com.rs.servlets;

import com.rs.core.JobRepository;
import com.rs.core.User;
import com.rs.core.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserProfile extends HttpServlet {
    UserRepository userRepository;
    JobRepository jobRepository;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        userRepository = new UserRepository();
        jobRepository = new JobRepository();
        int jobID = Integer.parseInt(request.getParameter("id"));
        int userID = ((User) getServletConfig().getServletContext().getAttribute("user")).getId();
        try{
        userRepository.save_map(jobID, userID);
        request.setAttribute("appliedJobs", jobRepository.getJobsWithID(userRepository.getAppliedJob(userID)));
        request.getRequestDispatcher("profile.jsp").forward(request, response);
        }
        catch (Exception e){
            request.setAttribute("message",e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
