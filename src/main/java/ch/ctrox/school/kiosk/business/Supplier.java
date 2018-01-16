package ch.ctrox.school.kiosk.business;

import ch.ctrox.school.kiosk.business.products.Inventory;
import ch.ctrox.school.kiosk.error.InvalidInventoryException;
import ch.ctrox.school.kiosk.tools.InventoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

import ch.ctrox.school.kiosk.business.products.Product;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */
public class Supplier {
  private Inventory inventory;
  private static final Logger logger = LogManager.getLogger(Supplier.class);

  public Supplier() {
    InventoryService service = new InventoryService("supplier", null);
    // load supplier inventory
    try {
      inventory = service.load();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InvalidInventoryException e) {
      e.printStackTrace();
    }
  }

  public Inventory getInventory() {
    return inventory;
  }

  public boolean orderProducts(Collection<Product> productList, double money) throws IOException, InvalidInventoryException {
    for (Product product : productList) {
      if (inventory.get(product.getId()) == null) {
        logger.error(String.format("Error ordering product %sx %s", product.getCount(), product.getName()));
      }
      logger.info(String.format("Ordering product %sx %s", product.getCount(), product.getName()));
    }
    return true;
  }
}
