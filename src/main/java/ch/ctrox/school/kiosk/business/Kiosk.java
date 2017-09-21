package ch.ctrox.school.kiosk.business;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */

public class Kiosk {
  private String name;
  private String location;
  private int id;
  private enum state {
    OPEN,
    CLOSED
  }

  private Employee employee;
  private Checkout checkout;
  private Supplier supplier;
}
