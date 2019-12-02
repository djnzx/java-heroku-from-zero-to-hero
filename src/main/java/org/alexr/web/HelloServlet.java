package org.alexr.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try (PrintWriter w = resp.getWriter();) {
      w.println("HelloServlet.GET3");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try (PrintWriter w = resp.getWriter();) {
      w.println("HelloServlet.POST");
    }
  }
}
