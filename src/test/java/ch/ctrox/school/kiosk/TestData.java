package ch.ctrox.school.kiosk;

import ch.ctrox.school.kiosk.business.products.Inventory;
import ch.ctrox.school.kiosk.error.InvalidInventoryException;
import ch.ctrox.school.kiosk.tools.InventoryService;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Loads test data for use in tests
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 03/01/18
 */
public class TestData {
  public static Inventory Get() {
    InventoryService loader = new InventoryService("test", null);
    try {
      return loader.load();
    } catch (IOException | InvalidInventoryException e) {
      e.printStackTrace();
    }
    return null;
  }
}
