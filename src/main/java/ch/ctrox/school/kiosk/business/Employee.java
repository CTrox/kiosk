package ch.ctrox.school.kiosk.business;

import java.util.Date;

import ch.ctrox.school.kiosk.business.products.Product;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */
public class Employee {
  private String name;
  private int id;
  private int kioskId;

  public class UnderageException extends Exception {
    public UnderageException() { super(); }
    public UnderageException(String message) { super(message); }
    public UnderageException(String message, Throwable cause) { super(message, cause); }
    public UnderageException(Throwable cause) { super(cause); }
  }


  public Employee(String name) {
    this.name = name;
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

  private int getAgeFromBirthDate(Date birthDate) {
    return 15;

  }

  public Product sellProduct(Product product, Customer customer) throws UnderageException {
    if (product.requiresAgeCheck()) {
      if (getAgeFromBirthDate(customer.getBirthDate()) < product.getRequiredAge()) {
        throw new UnderageException("Sorry, you are too young to buy this");
      }
    }
    return product;
  }
}
