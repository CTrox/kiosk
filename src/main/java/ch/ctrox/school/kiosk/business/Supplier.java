package ch.ctrox.school.kiosk.business;

import ch.ctrox.school.kiosk.business.products.Inventory;
import ch.ctrox.school.kiosk.error.InvalidInventoryException;
import ch.ctrox.school.kiosk.tools.InventoryLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

import ch.ctrox.school.kiosk.business.products.Product;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */
public class Supplier {
  private static final Logger logger = LogManager.getLogger(Supplier.class);

  public boolean orderProducts(Path inventoryFile, double money) throws IOException, InvalidInventoryException {
    InventoryLoader loader = new InventoryLoader();
    Inventory productList = loader.load(inventoryFile);
    for (Product product : productList.getList()) {
      logger.info(String.format("Ordering product %sx %s", product.getCount(), product.getName()));
    }
    return true;
  }
}
