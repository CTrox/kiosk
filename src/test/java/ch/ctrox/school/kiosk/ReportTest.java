package ch.ctrox.school.kiosk;

import org.junit.Test;

import java.io.IOException;

import ch.ctrox.school.kiosk.business.products.Inventory;
import ch.ctrox.school.kiosk.tools.Report;

public class ReportTest {
  @Test
  public void TestReport() {
    Inventory inventory = TestData.Get();
    Report report = new Report();
    try {
      report.generate(inventory);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
