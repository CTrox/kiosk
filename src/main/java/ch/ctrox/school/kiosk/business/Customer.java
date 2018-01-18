package ch.ctrox.school.kiosk.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Customer class
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 21/09/17
 */
public class Customer extends Thread {
  private static final AtomicInteger count = new AtomicInteger(0);
  private static final Logger logger = LogManager.getLogger(Kiosk.class);
  private Calendar birthDate;
  private int age;
  private long id;

  private Customer() {
    this.id = count.incrementAndGet();
  }

  /**
   * Creates a customer and runs it
   * @return customer object
   */
  public static Customer create() {
    Customer customer = new Customer();
    logger.info(String.format("Creating customer %s", customer.id));
    customer.run();
    return customer;
  }

  public void run(){
    try {
      logger.info(String.format("Customer %s is entering the kiosk", this.id));
      sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public long getId() {
    return id;
  }

  public Calendar getBirthDate() {
    return birthDate;
  }

  /**
   * Takes birtDate and calculates age
   * @param birthDate to set
   */
  public void setBirthDate(Calendar birthDate) {
    this.birthDate = birthDate;
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    this.age = currentYear - birthDate.get(Calendar.YEAR);
  }

  public int getAge() {
    return age;
  }

  /**
   * Gets cash from customer, the customer always has cash
   * @param amount the amount to get
   * @return the cash
   */
  public double getCash(double amount) {
    logger.info(String.format("Customer %s is paying", this.id));
    return amount;
  }

}
