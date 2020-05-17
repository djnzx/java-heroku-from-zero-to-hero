package org.alexr.step;

import org.alexr.step.db.DbSetup;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * http://localhost:8080/hello
 * http://localhost:8080/hello?x=5
 */
public class StepWebApp {
  public static void main(String[] args) throws Exception {
    DbSetup.migrate("jdbc:postgresql://localhost:5432/ibatech", "postgres", "secret");

    Server server = new Server(8080);

    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(HelloServlet.class, "/hello");
    server.setHandler(handler);

    server.start();
    server.join();
  }
}
