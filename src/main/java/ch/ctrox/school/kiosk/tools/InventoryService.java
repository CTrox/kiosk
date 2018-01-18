package ch.ctrox.school.kiosk.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import ch.ctrox.school.kiosk.business.products.Inventory;
import ch.ctrox.school.kiosk.business.products.Product;
import ch.ctrox.school.kiosk.business.products.ProductFactory;
import ch.ctrox.school.kiosk.error.InvalidInventoryException;

/**
 * InventoryService class
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 03/01/18
 */
public class InventoryService {
  private String name;
  private String basePath;

  /**
   * Creates a new InventoryService
   * @param name the name of the inventory
   * @param basePath the file path where the inventory
   * is stored/loaded from
   */
  public InventoryService(String name, String basePath) {
    this.name = name;
    if (basePath == null) {
      // use default path if not set
      basePath = "./src/test/csv";
    }
    this.basePath = basePath;
  }

  /**
   * Loads the inventory from a csv file
   * @return a inventory object
   * @throws IOException if the file load fails
   * @throws InvalidInventoryException if the inventory format is invalid
   */
  public Inventory load() throws IOException, InvalidInventoryException {
    List<String> csv = Files.readAllLines(Paths.get(String.format("%s/%s_inventory.csv", basePath, name)));
    return csvToInventory(csv);
  }

  /**
   * Stores a inventory to a csv file
   * @param inventory to store
   * @throws IOException if the file write fails
   */
  public void store(Inventory inventory) throws IOException {
    Files.write(Paths.get(String.format("%s/%s_inventory.csv", basePath, name)), inventoryToCSV(inventory));
  }

  /**
   * Parses the actual csv to a inventory object
   * @param csv file as a List<String>
   * @return the inventory
   * @throws InvalidInventoryException if the inventory format is invalid
   */
  private Inventory csvToInventory(List<String> csv) throws InvalidInventoryException {
    Inventory inventory = new Inventory();
    for (ListIterator<String> it = csv.listIterator(); it.hasNext();) {
      // skip the header line
      if (it.nextIndex() == 0) {
        it.next();
        continue;
      }

      String[] lineArr = it.next().split(",");
      if (lineArr.length != 6) {
        throw new InvalidInventoryException("Inventory CSV should have 6 columns");
      }
      int id = Integer.parseInt(lineArr[0]);
      String name = lineArr[1];
      String category = lineArr[2];
      String description = lineArr[3];
      double price = Double.parseDouble(lineArr[4]);
      int count = Integer.parseInt(lineArr[5]);
      Product product = ProductFactory.build(category);
      if (product == null) {
        throw new InvalidInventoryException("Invalid category in list: " + category);
      }
      product.setId(id);
      product.setName(name);
      product.setPrice(price);
      product.setDescription(description);
      product.setCount(count);
      inventory.add(product);
    }
    return inventory;
  }

  /**
   * Converts a inventory to a csv byte array
   * @param inventory to convert
   * @return a byte array of the inventory in a csv format
   */
  public byte[] inventoryToCSV(Inventory inventory) {
    StringBuilder sb = new StringBuilder();
    appendHeader(sb);
    // use sorted by price for storage
    for (Product product: inventory.getListSortedByPrice()) {
      // append product to StringBuilder
      appendProduct(sb, product);
    }
    return sb.toString().getBytes();
  }

  /**
   * Appends a csv header
   * @param sb to append to
   */
  private void appendHeader(StringBuilder sb) {
    // id,name,category,description,price,count
    sb.append("id");
    sb.append(',');
    sb.append("name");
    sb.append(',');
    sb.append("category");
    sb.append(',');
    sb.append("description");
    sb.append(',');
    sb.append("price");
    sb.append(',');
    sb.append("count");
    sb.append('\n');
  }

  /**
   * Appends a product
   * @param sb to append to
   * @param product to use
   */
  private void appendProduct(StringBuilder sb, Product product) {
    sb.append(product.getId());
    sb.append(',');
    sb.append(product.getName());
    sb.append(',');
    sb.append(product.getClass().getSimpleName());
    sb.append(',');
    sb.append(product.getDescription());
    sb.append(',');
    sb.append(product.getPrice());
    sb.append(',');
    sb.append(product.getCount());
    sb.append('\n');
  }
}
