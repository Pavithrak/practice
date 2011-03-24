package com.rs.core;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebServer {
    private Server server;

    public void runServer() throws Exception{
        server = new Server(8060);
         WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar("/home/pavithra/Documents/kavitha/RS/dest/recruit.war");
        server.setHandler(webapp);
        server.start();
        server.join();
    }
    public static void main(String[] args) throws Exception{
       new WebServer().runServer();

    }
}
