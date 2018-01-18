package ch.ctrox.school.kiosk.business.products;

/**
 * The Magazine product
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 21/09/17
 */
public class Magazine extends AbstractProduct {
  public Magazine(String name) {
    super(name);
  }

  public Magazine() {
    super();
  }

  /**
   * Defines all Magazine types
   */
  public enum Type {
    LOCAL("Lokal"),
    INTERNATIONAL("International"),
    GOSSIP("Klatsch"),
    CHILDREN("Kinder"),
    TECH("Technologie"),
    CAR("Auto"),
    COMIC("Comic");

    private String germanWord;

    Type(String germanWord) {
      this.germanWord = germanWord;
    }
  }
}
