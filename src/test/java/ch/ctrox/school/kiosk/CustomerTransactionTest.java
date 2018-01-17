package ch.ctrox.school.kiosk;

import ch.ctrox.school.kiosk.business.Kiosk;
import ch.ctrox.school.kiosk.business.products.Snack;
import ch.ctrox.school.kiosk.error.InvalidProductException;
import ch.ctrox.school.kiosk.error.OutOfStockException;
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
  public void testBuyingAlcoholToUnderage() throws NoIdentificationException, UnderageException, InvalidProductException, OutOfStockException {
    Kiosk kiosk = new Kiosk();
    Employee employee = new Employee("Hans Verkauf", kiosk);
    Customer customer = new Customer();
    customer.setBirthDate(new GregorianCalendar(2010, 3, 23));
    Product vodka = new StrongAlcohol("Vodka");
    employee.sellProduct(vodka, customer);
  }

  @Test(expected = NoIdentificationException.class)
  public void testBuyingAlcoholWithoutID() throws NoIdentificationException, UnderageException, InvalidProductException, OutOfStockException {
    Kiosk kiosk = new Kiosk();
    Employee employee = new Employee("Hans Verkauf", kiosk);
    Customer customer = new Customer();
    Product vodka = new StrongAlcohol("Vodka");
    employee.sellProduct(vodka, customer);
  }

  @Test(expected = InvalidProductException.class)
  public void testBuyingInvalidProduct() throws NoIdentificationException, UnderageException, InvalidProductException, OutOfStockException {
    Kiosk kiosk = new Kiosk();
    Employee employee = new Employee("Hans Verkauf", kiosk);
    Customer customer = new Customer();
    Product invalid = new Snack("Invalid product");
    employee.sellProduct(invalid, customer);
  }

  @Test(expected = OutOfStockException.class)
  public void testBuyingOutOfStockProduct() throws NoIdentificationException, UnderageException, InvalidProductException, OutOfStockException {
    Kiosk kiosk = new Kiosk();
    Employee employee = new Employee("Hans Verkauf", kiosk);
    Customer customer = new Customer();
    Product moon = new Snack("Moon");
    moon.setCount(10000);
    employee.sellProduct(moon, customer);
  }

  @Test()
  public void testNormalTransaction() throws NoIdentificationException, InvalidProductException, UnderageException, OutOfStockException {
    Kiosk kiosk = new Kiosk();
    Employee employee = new Employee("Hans Verkauf", kiosk);
    Customer customer = new Customer();
    Product magazine = new Magazine("Ride");
    employee.sellProduct(magazine, customer);
  }
}