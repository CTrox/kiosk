package ch.ctrox.school.kiosk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.Date;

import ch.ctrox.school.kiosk.business.Customer;
import ch.ctrox.school.kiosk.business.Employee;
import ch.ctrox.school.kiosk.business.products.Product;
import ch.ctrox.school.kiosk.business.products.StrongAlcohol;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 21/09/17
 */

public class EmployeeTest {
  private static final Logger logger = LogManager.getLogger(EmployeeTest.class);

  @Test
  public static void main(String[] args) {

    Employee employee = new Employee("Hans Verkauf");
    Customer customer = new Customer();
    customer.setBirthDate(new Date());
    Product vodka = new StrongAlcohol("Vodka");
    try {
      employee.sellProduct(vodka, customer);
    } catch (Employee.UnderageException e) {
      logger.error(e.getMessage());
      e.printStackTrace();
    }
  }
}