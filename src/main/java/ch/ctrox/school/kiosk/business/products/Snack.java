package ch.ctrox.school.kiosk.business.products;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 21/09/17
 */
public class Snack extends AbstractProduct {
  Snack(String name) {
    super(name);
  }

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
