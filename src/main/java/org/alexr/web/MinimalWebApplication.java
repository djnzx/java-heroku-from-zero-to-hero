package org.alexr.web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * https://www.baeldung.com/executable-jar-with-maven
 * http://localhost:5000
 */
public class MinimalWebApplication {
  public static void main(String[] args) throws Exception {
    int port;
    try {
      port = Integer.parseInt(System.getenv("PORT"));
    } catch (NumberFormatException ex) {
      port = 5000;
    }
    Server server = new Server(port);

    ServletContextHandler handler = new ServletContextHandler();

    handler.addServlet(HelloServlet.class, "/*");

    server.setHandler(handler);
    server.start();;
    server.join();
  }
}
