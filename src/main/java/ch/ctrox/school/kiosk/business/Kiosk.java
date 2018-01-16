package ch.ctrox.school.kiosk.business;

import ch.ctrox.school.kiosk.business.products.Inventory;
import ch.ctrox.school.kiosk.error.InvalidInventoryException;
import ch.ctrox.school.kiosk.tools.InventoryService;

import java.io.IOException;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */

public class Kiosk {
  private String name;
  private String location;
  private int id;

  public Inventory getInventory() {
    return inventory;
  }

  private enum state {
    OPEN,
    CLOSED
  }

  private Employee employee;
  private Checkout checkout;
  private Supplier supplier;
  private Inventory inventory;

  public Kiosk() {
    InventoryService service = new InventoryService("kiosk", null);
    // load supplier inventory
    try {
      inventory = service.load();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InvalidInventoryException e) {
      e.printStackTrace();
    }
  }
}
