package ch.ctrox.school.kiosk.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import ch.ctrox.school.kiosk.business.products.Inventory;
import ch.ctrox.school.kiosk.business.products.Product;

public class Report {
  public void generate(Inventory inventory) throws IOException {
    Files.write(Paths.get("./src/test/csv/inventory.csv"), productsToCSV(inventory).getBytes());
  }

  private String productsToCSV(Inventory inventory) {
    StringBuilder sb = new StringBuilder();
    appendHeader(sb);
    // sort collection by price (descending)
    Collection<Product> sortedInventory = inventory.getList().stream()
            .sorted(Comparator.comparing(Product::getPrice).reversed())
            .collect(Collectors.toList());
    for (Product product: sortedInventory) {
      appendProduct(sb, product);
    }
    return sb.toString();
  }

  private void appendHeader(StringBuilder sb) {
    sb.append("Artikelbezeichnung");
    sb.append(',');
    sb.append("Preis");
    sb.append(',');
    sb.append("Stückzahl");
    sb.append('\n');
  }

  private void appendProduct(StringBuilder sb, Product product) {
    sb.append(product.getName());
    sb.append(',');
    sb.append(product.getPrice());
    sb.append(',');
    sb.append(product.getCount());
    sb.append('\n');
  }
}
