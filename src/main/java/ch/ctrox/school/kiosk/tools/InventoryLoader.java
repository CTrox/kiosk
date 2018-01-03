package ch.ctrox.school.kiosk.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;

import ch.ctrox.school.kiosk.business.products.Inventory;
import ch.ctrox.school.kiosk.business.products.Product;
import ch.ctrox.school.kiosk.business.products.ProductFactory;
import ch.ctrox.school.kiosk.error.InvalidInventoryException;

public class InventoryLoader {
  public Inventory load(String fileName) throws IOException, InvalidInventoryException {
    List<String> csv = Files.readAllLines(Paths.get(fileName));
    return csvToInventory(csv);
  }

  private Inventory csvToInventory(List<String> csv) throws InvalidInventoryException {
    Inventory inventory = new Inventory();
    for (ListIterator<String> it = csv.listIterator(); it.hasNext();) {
      // skip the header line
      if (it.nextIndex() == 0) {
        continue;
      }

      String[] lineArr = it.next().split(",");
      if (lineArr.length < 6) {
        throw new InvalidInventoryException("Inventory CSV should have 6 columns");
      }
      int id = Integer.parseInt(lineArr[0]);
      String name = lineArr[1];
      String category = lineArr[2];
      String description = lineArr[3];
      double price = Double.parseDouble(lineArr[4]);
      Product product = ProductFactory.build(category);
      if (product == null) {
        throw new InvalidInventoryException("Invalid category in list: " + category);
      }
      product.setId(id);
      product.setName(name);
      product.setPrice(price);
      product.setDescription(description);
      inventory.add(product);
    }
    return inventory;
  }
}
