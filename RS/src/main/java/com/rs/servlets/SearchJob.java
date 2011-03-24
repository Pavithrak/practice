package com.rs.servlets;

import com.rs.core.Job;
import com.rs.core.JobRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class SearchJob extends HttpServlet {

    JobRepository repository;
    Job[] jobList;
    RequestDispatcher requestDispatcher;

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        repository = new JobRepository();
        response.setContentType("text/html");
        Map<String, String[]> paramNameValue = request.getParameterMap();
        jobList = repository.getJobs(paramNameValue);
        getServletConfig().getServletContext().setAttribute("jobList", jobList);
        requestDispatcher = request.getRequestDispatcher("/result.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
