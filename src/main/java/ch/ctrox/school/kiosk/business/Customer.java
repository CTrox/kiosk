package ch.ctrox.school.kiosk.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 21/09/17
 */
public class Customer {
  private static final AtomicInteger count = new AtomicInteger(0);
  private static final Logger logger = LogManager.getLogger(Kiosk.class);
  private Calendar birthDate;
  private int age;
  private long id;

  public Customer() {
    this.id = count.incrementAndGet();
    logger.info(String.format("Creating customer %s", this.id));
  }

  public long getId() {
    return id;
  }

  public Calendar getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Calendar birthDate) {
    this.birthDate = birthDate;
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    this.age = currentYear - birthDate.get(Calendar.YEAR);
  }

  public int getAge() {
    return age;
  }

  // customer always got cash
  public double getCash(double amount) {
    return amount;
  }

}
