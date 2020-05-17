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

}
