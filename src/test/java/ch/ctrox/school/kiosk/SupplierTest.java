package ch.ctrox.school.kiosk;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import ch.ctrox.school.kiosk.business.Supplier;
import ch.ctrox.school.kiosk.business.products.LightAlcohol;
import ch.ctrox.school.kiosk.business.products.Product;
import ch.ctrox.school.kiosk.business.products.SoftDrink;
import ch.ctrox.school.kiosk.business.products.StrongAlcohol;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 21/09/17
 */

public class SupplierTest {
  @Test
  public static void main(String[] args) {
    Product vodka = new StrongAlcohol("Vodka");
    Product beer = new LightAlcohol("Sudwerk Pale Ale");
    Product coke = new SoftDrink("Coca Cola");
    List<Product> productList = new ArrayList<>();
    productList.add(vodka);
    productList.add(beer);
    productList.add(coke);

    Supplier supplier = new Supplier();
    supplier.orderProducts(productList);

  }
}