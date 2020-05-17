package org.alexr.step;

import org.alexr.step.db.ConnDetails;
import org.alexr.step.db.DbConn;
import org.alexr.step.db.DbSetup;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.sql.Connection;

/**
 * http://localhost:8080/hello
 * http://localhost:8080/hello?x=1
 * http://localhost:8080/hello?x=2
 */
public class StepWebApp {
  public static void main(String[] args) throws Exception {
    DbSetup.migrate(ConnDetails.url, ConnDetails.username, ConnDetails.password);
    Connection conn = DbConn.create(ConnDetails.url, ConnDetails.username, ConnDetails.password);

    Server server = new Server(8080);

    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(new ServletHolder(new HelloServlet(conn)), "/hello");
    server.setHandler(handler);

    server.start();
    server.join();
  }
}
