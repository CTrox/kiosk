package ch.ctrox.school.kiosk.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

import ch.ctrox.school.kiosk.business.products.Product;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */
public class Employee {
  private static final AtomicInteger count = new AtomicInteger(0);
  private String name;
  private int id;
  private int kioskId;

  private static final Logger logger = LogManager.getLogger(Employee.class);

  public class UnderageException extends Exception {
    public UnderageException(String message) { super(message); }
  }

  public class NoIdentificationException extends Exception {
    public NoIdentificationException(String message) { super(message); }
  }

  public Employee(String name) {
    this.name = name;
    this.id = count.incrementAndGet();
  }

  public String getName() {
    return name;
  }

  public int getKioskId() {
    return kioskId;
  }

  public void setKioskId(int kioskId) {
    this.kioskId = kioskId;
  }

  public Product sellProduct(Product product, Customer customer) throws UnderageException, NoIdentificationException {
    if (product.requiresAgeCheck()) {
      if (customer.getBirthDate() == null) {
        throw new NoIdentificationException(String.format(
            "Error selling product '%s', customer %s does not have a way to verify birthdate",
            product.getName(),
            customer.getId()
        ));
      }
      if (customer.getAge() < product.getRequiredAge()) {
        throw new UnderageException(String.format(
            "Error selling product '%s', customer %s is underage",
            product.getName(),
            customer.getId()
        ));
      }
    }
    Checkout checkout = new Checkout();
    double cash = customer.getCash(product.getPrice());
    checkout.putCash(cash);

    logger.info(String.format(
        "Sold product '%s' to customer %s", product.getName(), customer.getId()
    ));
    logger.info(String.format(
        "Balance is: %s.-", checkout.getBalance()
    ));
    return product;
  }
}
