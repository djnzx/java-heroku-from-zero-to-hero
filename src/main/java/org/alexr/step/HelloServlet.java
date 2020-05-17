package org.alexr.step;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Optional<String> ox = Optional.ofNullable(req.getParameter("x"));

    try (PrintWriter w = resp.getWriter()) {
      w.write("x=");
      w.write(ox.toString());
    }
  }
}
