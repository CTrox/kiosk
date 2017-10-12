package ch.ctrox.school.kiosk.business;

import ch.ctrox.school.kiosk.error.InsufficentFundsException;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */
public class Checkout {
  private double cash;

  public void putCash(double cash) {
    this.cash =+ cash;
  }

  public double getCash(double amount) throws InsufficentFundsException {
    if (amount < cash) {
      return cash;
    } else {
      throw new InsufficentFundsException(String.format(
          "Not enough cash in Checkout: requested amount %s; current balance %s", amount, this.cash
      ));
    }
  }

  public double getBalance() {
    return this.cash;
  }
}
