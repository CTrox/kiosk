package ch.ctrox.school.kiosk.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import ch.ctrox.school.kiosk.business.products.Inventory;
import ch.ctrox.school.kiosk.error.InvalidInventoryException;

public class InventoryLoader {
  public Inventory load(String fileName) throws IOException, InvalidInventoryException {
    List<String> csv = Files.readAllLines(Paths.get(fileName));
    return csvToInventory(csv);
  }

  private Inventory csvToInventory(List<String> csv) throws InvalidInventoryException {
    Inventory inventory = new Inventory();
    for (String line : csv) {
      String[] lineArr = line.split(",");
      if (lineArr.length < 6) {
        throw new InvalidInventoryException("Inventory CSV should have 6 columns");
      }
      // TODO: this is unfinished
    }
    return inventory;
  }
}
