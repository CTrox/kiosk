package ch.ctrox.school.kiosk;

import ch.ctrox.school.kiosk.tools.InventoryService;
import org.junit.Test;

import java.io.IOException;

import ch.ctrox.school.kiosk.business.products.Inventory;

/**
 * Tests getting and storing of the InventoryService
 */
public class InventoryTest {
  @Test
  public void TestReport() {
    Inventory inventory = TestData.Get();
    InventoryService service = new InventoryService("test", null);
    try {
      service.store(inventory);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
