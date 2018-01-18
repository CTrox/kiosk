package ch.ctrox.school.kiosk.business;

import ch.ctrox.school.kiosk.business.products.Inventory;
import ch.ctrox.school.kiosk.error.InvalidInventoryException;
import ch.ctrox.school.kiosk.tools.InventoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Kiosk class
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */

public class Kiosk {
  private static final AtomicInteger count = new AtomicInteger(0);
  private static final Logger logger = LogManager.getLogger(Kiosk.class);
  private String location;
  private int id;
  private state openState;
  private Employee employee;
  private Checkout checkout;
  private Supplier supplier;
  private Inventory inventory;

  /**
   * Kiosk states
   */
  private enum state {
    OPEN,
    CLOSED
  }

  public Inventory getInventory() {
    return inventory;
  }

  public state getOpenState() {
    return openState;
  }

  /**
   * Creates a new kiosk
   * @param location the location of the to be created kiosk
   */
  public Kiosk(String location) {
    this.id = count.incrementAndGet();
    this.location = location;
    InventoryService service = new InventoryService("kiosk", null);
    logger.info(String.format("Creating kiosk %s in %s", id, location));
    try {
      // load supplier inventory
      this.inventory = service.load();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InvalidInventoryException e) {
      e.printStackTrace();
    }
  }

  /**
   * Opens the kiosk
   * @param employee who wants to open it
   */
  public void open(Employee employee) {
    logger.info(String.format(
            "%s opens kiosk %s in %s",
            employee.getName(), this.id, this.location)
    );
    this.openState = state.OPEN;
  }

  /**
   * Closes the kiosk
   * @param employee who wants to close it
   */
  public void close(Employee employee) {
    logger.info(String.format(
            "%s closes kiosk %s in %s",
            employee.getName(), this.id, this.location)
    );
    this.openState = state.CLOSED;
  }
}
