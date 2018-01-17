package ch.ctrox.school.kiosk.error;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/10/17
 */
public class InvalidProductException extends Exception {
  public InvalidProductException(String message) {
    super(message);
  }
}
