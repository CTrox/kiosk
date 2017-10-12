package ch.ctrox.school.kiosk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.GregorianCalendar;

import ch.ctrox.school.kiosk.business.Customer;
import ch.ctrox.school.kiosk.business.Employee;
import ch.ctrox.school.kiosk.business.products.Magazine;
import ch.ctrox.school.kiosk.business.products.Product;
import ch.ctrox.school.kiosk.business.products.StrongAlcohol;
import ch.ctrox.school.kiosk.error.NoIdentificationException;
import ch.ctrox.school.kiosk.error.UnderageException;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 21/09/17
 */

public class CustomerTransactionTest {
  private static final Logger logger = LogManager.getLogger(CustomerTransactionTest.class);

  @Test(expected = UnderageException.class)
  public void testSellingAlcoholToUnderage() throws NoIdentificationException, UnderageException {
    Employee employee = new Employee("Hans Verkauf");
    Customer customer = new Customer();
    customer.setBirthDate(new GregorianCalendar(2010, 3, 23));
    Product vodka = new StrongAlcohol("Vodka");
    employee.sellProduct(vodka, customer);
  }

  @Test
  public void testNormalTransaction() {
    Employee employee = new Employee("Hans Verkauf");
    Customer customer = new Customer();
    Product magazine = new Magazine("Ride");
    try {
      employee.sellProduct(magazine, customer);
    } catch (UnderageException e) {
      logger.error(e.getMessage());
      e.printStackTrace();
    } catch (NoIdentificationException e) {
      e.printStackTrace();
    }
  }
}