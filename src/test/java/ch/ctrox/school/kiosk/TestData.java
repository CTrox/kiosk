package ch.ctrox.school.kiosk;

import ch.ctrox.school.kiosk.business.products.Inventory;
import ch.ctrox.school.kiosk.business.products.LightAlcohol;
import ch.ctrox.school.kiosk.business.products.Product;
import ch.ctrox.school.kiosk.business.products.SoftDrink;
import ch.ctrox.school.kiosk.business.products.StrongAlcohol;

public class TestData {
  public static Inventory Get() {
    Inventory inventory = new Inventory();
    Product vodka = new StrongAlcohol("Vodka");
    vodka.setId(1);
    Product beer = new LightAlcohol("Sudwerk Pale Ale");
    beer.setId(2);
    Product coke = new SoftDrink("Coca Cola");
    coke.setId(3);
    inventory.add(vodka);
    inventory.add(beer);
    inventory.add(coke);
    return inventory;
  }
}
