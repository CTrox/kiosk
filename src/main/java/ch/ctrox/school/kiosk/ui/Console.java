package ch.ctrox.school.kiosk.ui;

/**
 * Initially meant for a console UI but not really implemented/required
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */
public class Console {
  private static Console instance = null;

  public static Console getInstance() {
    if (instance == null) {
      return new Console();
    }
    return instance;
  }

  public void start() {
    System.out.println("Welcome to kiosk");
  }
}
