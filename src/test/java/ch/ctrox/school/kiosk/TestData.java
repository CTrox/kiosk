package ch.ctrox.school.kiosk;

import ch.ctrox.school.kiosk.business.products.Inventory;
import ch.ctrox.school.kiosk.business.products.LightAlcohol;
import ch.ctrox.school.kiosk.business.products.Product;
import ch.ctrox.school.kiosk.business.products.SoftDrink;
import ch.ctrox.school.kiosk.business.products.StrongAlcohol;
import ch.ctrox.school.kiosk.error.InvalidInventoryException;
import ch.ctrox.school.kiosk.tools.InventoryLoader;

import java.io.IOException;
import java.nio.file.Paths;

public class TestData {
  public static Inventory Get() {
    InventoryLoader loader = new InventoryLoader();
    try {
      Inventory inventory = loader.load(Paths.get("./src/test/csv/productlist.csv"));
      return inventory;
    } catch (IOException | InvalidInventoryException e) {
      e.printStackTrace();
    }
    return null;
  }
}
