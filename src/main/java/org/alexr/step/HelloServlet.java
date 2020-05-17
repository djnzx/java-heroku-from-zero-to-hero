package org.alexr.step;

import org.alexr.step.dao.DAOStudentSQL;
import org.alexr.step.dao.Student;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * http://localhost:8080/hello
 * http://localhost:8080/hello?x=1
 * http://localhost:8080/hello?x=2
 */
public class HelloServlet extends HttpServlet {

  private final Connection conn;

  public HelloServlet(Connection conn) {
    this.conn = conn;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Optional<String> ox = Optional.ofNullable(req.getParameter("x"));
    DAOStudentSQL dao = new DAOStudentSQL(conn);

    try (PrintWriter w = resp.getWriter()) {
      w.write("x=");
      w.write(ox.toString());
      w.write("\n");

      String outcome = ox.map(Integer::parseInt)
          .flatMap(dao::get)
          .map(Student::toString)
          .orElse(
              dao.getAll()
                  .stream()
                  .map(Student::toString)
                  .collect(Collectors.joining("\n"))
          );

      w.write(outcome);
    }
  }
}
