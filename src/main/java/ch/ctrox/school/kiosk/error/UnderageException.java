package ch.ctrox.school.kiosk.error;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/10/17
 */
public class UnderageException extends Exception {
  public UnderageException(String message) {
    super(message);
  }
}
