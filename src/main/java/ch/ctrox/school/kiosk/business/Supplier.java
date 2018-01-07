package ch.ctrox.school.kiosk.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.List;

import ch.ctrox.school.kiosk.business.products.Product;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */
public class Supplier {
  private static final Logger logger = LogManager.getLogger(Supplier.class);

  public boolean orderProducts(Collection<Product> productList, double money) {
    for (Product product : productList) {
      logger.info(String.format("Ordering product %s", product.getName()));
    }
    //productList.get(0)
    return true;
  }
}
