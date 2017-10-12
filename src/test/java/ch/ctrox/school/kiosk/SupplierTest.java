package ch.ctrox.school.kiosk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import ch.ctrox.school.kiosk.business.Checkout;
import ch.ctrox.school.kiosk.business.Supplier;
import ch.ctrox.school.kiosk.business.products.LightAlcohol;
import ch.ctrox.school.kiosk.business.products.Product;
import ch.ctrox.school.kiosk.business.products.SoftDrink;
import ch.ctrox.school.kiosk.business.products.StrongAlcohol;
import ch.ctrox.school.kiosk.error.InsufficentFundsException;

import static org.junit.Assert.assertTrue;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 21/09/17
 */

public class SupplierTest {
  private static final Logger logger = LogManager.getLogger(SupplierTest.class);

  @Test (expected = InsufficentFundsException.class)
  public void TestInvalidProductOrder() throws InsufficentFundsException {
    Checkout checkout = new Checkout();
    checkout.putCash(0.0);
    checkout.getCash(10);
  }

  @Test
  public void TestValidProductOrder() {
    Product vodka = new StrongAlcohol("Vodka");
    Product beer = new LightAlcohol("Sudwerk Pale Ale");
    Product coke = new SoftDrink("Coca Cola");
    Checkout checkout = new Checkout();
    checkout.putCash(1000000.0);

    List<Product> productList = new ArrayList<>();
    productList.add(vodka);
    productList.add(beer);
    productList.add(coke);
    double cash = 0.0;
    double orderPrice = Product.getPriceTotal(productList);
    try {
       cash = checkout.getCash(orderPrice);
    } catch (InsufficentFundsException e) {
      logger.error(e.getMessage());
      e.printStackTrace();
    }
    Supplier supplier = new Supplier();
    assertTrue(supplier.orderProducts(productList, cash));
  }
}