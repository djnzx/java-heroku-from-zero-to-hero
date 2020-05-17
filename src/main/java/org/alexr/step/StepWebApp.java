package org.alexr.step;

import org.alexr.step.db.ConnDetails;
import org.alexr.step.db.DbConn;
import org.alexr.step.db.DbSetup;
import org.alexr.step.servlets.HelloServlet;
import org.alexr.step.servlets.StudentServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.sql.Connection;

/**
 * http://localhost:8080/hello
 *
 * http://localhost:8080/student
 * http://localhost:8080/student?x=1
 * http://localhost:8080/student?x=2
 */
public class StepWebApp {
  public static void main(String[] args) throws Exception {
    // temporary
//    DbSetup.migrate(ConnDetails.url, ConnDetails.username, ConnDetails.password);
    // temporary
//    Connection conn = DbConn.create(ConnDetails.url, ConnDetails.username, ConnDetails.password);
    Connection conn = null;

    Server server = new Server(HerokuEnv.port());

    System.out.println("**********************");
    System.out.println("**********************");
    System.out.println(HerokuEnv.jdbc_url());
    System.out.println("**********************");
    System.out.println("**********************");



    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(HelloServlet.class, "/hello");
    handler.addServlet(new ServletHolder(new StudentServlet(conn)), "/student");
    server.setHandler(handler);

    server.start();
    server.join();
  }
}
