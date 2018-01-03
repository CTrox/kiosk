package ch.ctrox.school.kiosk.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

import ch.ctrox.school.kiosk.business.products.Inventory;
import ch.ctrox.school.kiosk.business.products.Product;

public class Report {
  public void generate(Inventory inventory) throws IOException {
    Files.write(Paths.get("./inventory.csv"), productsToCSV(inventory).getBytes());
  }

  private String productsToCSV(Inventory inventory) {
    StringBuilder sb = new StringBuilder();
    sb.append("Artikelbezeichnung");
    sb.append(',');
    sb.append("Preis");
    sb.append(',');
    sb.append("Stückzahl");
    sb.append('\n');
    for (Product product: inventory.getList()) {
      sb.append(product.getName());
      sb.append(',');
      sb.append(product.getPrice());
      sb.append(',');
      sb.append(Collections.frequency(inventory.getList(), product.getId()));
      sb.append('\n');
    }
    return sb.toString();
  }
}
