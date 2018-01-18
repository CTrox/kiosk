package ch.ctrox.school.kiosk.business.products;

/**
 * The Snack product
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 21/09/17
 */
public class Snack extends AbstractProduct {
  public Snack(String name) {
    super(name);
  }

  public Snack() {
    super();
  }

  /**
   * Defines all the Snack types
   */
  public enum Type {
    SANDWICH("Sandwich"),
    SWEET("Süssig"),
    SALTY("Salzig"),
    FRUIT("Frucht"),
    ICE_CREAM("Eis");

    private String germanWord;

    Type(String germanWord) {
      this.germanWord = germanWord;
    }
  }
}
