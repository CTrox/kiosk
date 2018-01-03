package ch.ctrox.school.kiosk.business.products;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 21/09/17
 */
public class Tobacco extends AbstractProduct {
  Tobacco(String name) {
    super(name);
  }

  public Tobacco() {
    super();
  }

  @Override
  public boolean requiresAgeCheck() {
    return true;
  }

  @Override
  public int getRequiredAge() {
    return 16;
  }
}
