package org.alexr.step;

public class HerokuEnv {

  public static int port() {
    try {
      return Integer.parseInt(System.getenv("PORT"));
    } catch (NumberFormatException ex) {
      return 5000;
    }
  }

  public static String jdbc_url() {
    String url = System.getenv("JDBC_DATABASE_URL");
    if (url == null) throw new IllegalArgumentException("JDBC_DATABASE_URL is empty!!!");
    return url;
  }

  public static String jdbc_username() {
    String url = System.getenv("JDBC_DATABASE_USERNAME");
    if (url == null) throw new IllegalArgumentException("JDBC_DATABASE_USERNAME is empty!!!");
    return url;
  }

  public static String jdbc_password() {
    String url = System.getenv("JDBC_DATABASE_PASSWORD");
    if (url == null) throw new IllegalArgumentException("JDBC_DATABASE_PASSWORD is empty!!!");
    return url;
  }

}
