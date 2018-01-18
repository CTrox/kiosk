package ch.ctrox.school.kiosk.business;

import ch.ctrox.school.kiosk.error.InsufficentFundsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The checkout which handles all the cash
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */
public class Checkout {
  private static final Logger logger = LogManager.getLogger(Checkout.class);
  private double cash;
  private Employee employee;

  /**
   * Constructor
   * @param employee who uses this checkout
   */
  public Checkout(Employee employee) {
    this.employee = employee;
  }

  /**
   * Inserts cash into the checkout
   * @param cash to insert
   */
  public void putCash(double cash) {
    logger.info(String.format("%s put %s.- into checkout", employee.getName(), cash));
    this.cash =+ cash;
  }

  /**
   * Gets cash from the checkout
   * @param amount to get
   * @return the cash
   * @throws InsufficentFundsException is thrown when more
   * cash is requested than the checkout currently has
   */
  public double getCash(double amount) throws InsufficentFundsException {
    logger.info(String.format("%s is taking %s.- from checkout", employee.getName(), cash));
    // check if we have enough cash
    if (amount < cash) {
      return cash;
    } else {
      throw new InsufficentFundsException(String.format(
          "Not enough cash in Checkout: requested amount %s; current balance %s", amount, this.cash
      ));
    }
  }

  /**
   * Get the balance of the checkout
   * @return a double of the cash amount
   */
  public double getBalance() {
    return this.cash;
  }
}
