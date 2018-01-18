package ch.ctrox.school.kiosk.business.products;

/**
 * The LightAlcohol (beer & wine) product
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */
public class LightAlcohol extends AbstractProduct {
  // specifies amount of beverage in decilitres
  private int amountInDCL;

  public LightAlcohol(String name) {
    super(name);
  }

  public LightAlcohol() {
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

  public int getAmountInDCL() {
    return amountInDCL;
  }

  public void setAmountInDCL(int amountInDCL) {
    this.amountInDCL = amountInDCL;
  }
}
