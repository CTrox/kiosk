package ch.ctrox.school.kiosk.business.products;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 21/09/17
 */
public class Magazine extends AbstractProduct {
  Magazine(String name) {
    super(name);
  }

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
