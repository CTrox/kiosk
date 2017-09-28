package ch.ctrox.school.kiosk.business;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */
public class Checkout {
  private double cash;
  public class NoCashException extends Exception {
    public NoCashException(String message) { super(message); }
  }

  public void putCash(double cash) {
    this.cash =+ cash;
  }

  public double getCash(double amount) throws NoCashException {
    if (amount < cash) {
      return cash;
    } else {
      throw new NoCashException(String.format(
          "Not enough cash in Checkout, current balance %s", this.cash
      ));
    }
  }

  public double getBalance() {
    return this.cash;
  }
}
