package org.alexr.step.db;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConn {
  @SneakyThrows
  public static Connection create(String url, String username, String password) {
    return DriverManager.getConnection(url, username, password);
  }

  @SneakyThrows
  public static Connection createFromURL(String jdbc_url) {
    return DriverManager.getConnection(jdbc_url);
  }
}
