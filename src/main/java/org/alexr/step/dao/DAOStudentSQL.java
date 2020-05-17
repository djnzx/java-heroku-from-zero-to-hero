package org.alexr.step.dao;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * http://localhost:8080/hello
 * http://localhost:8080/hello?x=5
 */
public class DAOStudentSQL implements DAO<Student> {

  private final Connection conn;
  private final String SQL_getAll = "select id, name from students";
  private final String SQL_get    = "select id, name from students where id = ?";
  private final String SQL_put    = "insert into students (name) values (?)";
  private final String SQL_delete = "delete from students where id = ?";

  public DAOStudentSQL(Connection conn) {
    this.conn = conn;
  }

  @SneakyThrows
  @Override
  public List<Student> getAll() {
    PreparedStatement stmt = conn.prepareStatement(SQL_getAll);
    ResultSet rset = stmt.executeQuery();
    ArrayList<Student> data = new ArrayList<>();
    while (rset.next()) {
      Student s = new Student(
          rset.getInt("id"),
          rset.getString("name")
      );
      data.add(s);
    }
    return data;
  }

  @Override
  public List<Student> getBy(Predicate<Student> p) {
    return getAll().stream().filter(p).collect(Collectors.toList());
  }

  @SneakyThrows
  @Override
  public Optional<Student> get(int id) {
    PreparedStatement stmt = conn.prepareStatement(SQL_get);
    stmt.setInt(1, id);
    ResultSet rset = stmt.executeQuery();
    return !rset.next() ? Optional.empty() : Optional.of(
        new Student(
            rset.getInt("id"),
            rset.getString("name")
        )
    );
  }

  @SneakyThrows
  @Override
  public void put(Student student) {
    PreparedStatement stmt = conn.prepareStatement(SQL_put);
    stmt.setString(1, student.getName());
    stmt.execute();
  }

  @SneakyThrows
  @Override
  public void delete(int id) {
    PreparedStatement stmt = conn.prepareStatement(SQL_delete);
    stmt.setInt(1, id);
    stmt.execute();
  }
}
