package ch.ctrox.school.kiosk.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 21/09/17
 */
public class Customer extends Thread {
  private static final AtomicInteger count = new AtomicInteger(0);
  private static final Logger logger = LogManager.getLogger(Kiosk.class);
  private Calendar birthDate;
  private int age;
  private long id;

  public void run(){
    System.out.println("Thread Running");
  }

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
  public double getCash(double amount) throws InterruptedException {
    logger.info(String.format("Customer %s is paying", this.id));
    sleep(5000);
    return amount;
  }

}
