package ch.ctrox.school.kiosk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.ctrox.school.kiosk.ui.Console;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */
public class Main {
  private static final Logger logger = LogManager.getLogger(Main.class);

  public static void main(String[] args) {
    logger.info("what");
    Console console = Console.getInstance();
    console.start();
  }
}
