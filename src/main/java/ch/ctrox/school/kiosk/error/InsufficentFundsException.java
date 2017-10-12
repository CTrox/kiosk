package ch.ctrox.school.kiosk.error;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/10/17
 */
public class InsufficentFundsException extends Exception {
  public InsufficentFundsException(String message) {
    super(message);
  }
}
