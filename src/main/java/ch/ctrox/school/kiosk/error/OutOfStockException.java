package ch.ctrox.school.kiosk.error;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/10/17
 */
public class OutOfStockException extends Exception {
  public OutOfStockException(String message) {
    super(message);
  }
}
