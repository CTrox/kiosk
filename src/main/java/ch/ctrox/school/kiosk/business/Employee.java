package ch.ctrox.school.kiosk.business;

import ch.ctrox.school.kiosk.error.InvalidProductException;
import ch.ctrox.school.kiosk.error.OutOfStockException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

import ch.ctrox.school.kiosk.business.products.Product;
import ch.ctrox.school.kiosk.error.NoIdentificationException;
import ch.ctrox.school.kiosk.error.UnderageException;

/**
 * Employee class
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */
public class Employee {
  private static final AtomicInteger count = new AtomicInteger(0);
  private static final Logger logger = LogManager.getLogger(Employee.class);
  private String name;
  private int id;
  private Kiosk kiosk;

  /**
   * Creates a new employee
   * @param name the name of the employee
   * @param kiosk the kiosk the employee belongs to
   */
  public Employee(String name, Kiosk kiosk) {
    this.name = name;
    this.kiosk = kiosk;
    this.id = count.incrementAndGet();
    // open kiosk
    kiosk.open(this);
  }

  public String getName() {
    return name;
  }

  public Kiosk getKiosk() {
    return kiosk;
  }

  public void setKiosk(Kiosk kiosk) {
    this.kiosk = kiosk;
  }

  /**
   * Does quite a few checks and eventually
   * sells a product to the customer
   * @param product the requested product to sell
   * @param customer the customer who buys it
   * @return the bought product
   * @throws UnderageException the customer is too young to buy
   * @throws NoIdentificationException the customer does not have an ID to show
   * @throws InvalidProductException the requested product does not exist
   * @throws OutOfStockException the requested amount of product is not available
   */
  public Product sellProduct(Product product, Customer customer)
          throws UnderageException, NoIdentificationException, InvalidProductException, OutOfStockException {
    Product inventoryProduct = kiosk.getInventory().getByName(product.getName());

    if (inventoryProduct == null) {
      throw new InvalidProductException(String.format(
              "Requested Product '%s' does not exist in kiosk inventory",
              product.getName()));
    }

    if (inventoryProduct.getCount() < product.getCount()) {
      throw new OutOfStockException(String.format(
              "Requested count (%s) of Product '%s' is more than in stock",
              product.getName(),
              product.getCount()));
    }

    // use the product from the inventory as it is more complete
    product = inventoryProduct;

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

    Checkout checkout = new Checkout(this);
    double cash = 0;
    cash = customer.getCash(product.getPrice());
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
