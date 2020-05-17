package org.alexr.step;

public class HerokuEnv {
  public static int port() {
    try {
      return Integer.parseInt(System.getenv("PORT"));
    } catch (NumberFormatException ex) {
      return 5000;
    }
  }
}
