package ch.ctrox.school.kiosk.business.products;

/**
 * The StrongAlcohol (Everything not beer or wine) Product
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */
public class StrongAlcohol extends AbstractProduct {
  // specifies amount of beverage in decilitres
  private int amountInDCL;

  public StrongAlcohol(String name) {
    super(name);
  }

  public StrongAlcohol() {
    super();
  }

  @Override
  public boolean requiresAgeCheck() {
    return true;
  }

  @Override
  public int getRequiredAge() {
    return 18;
  }


  public int getAmountInDCL() {
    return amountInDCL;
  }

  public void setAmountInDCL(int amountInDCL) {
    this.amountInDCL = amountInDCL;
  }
}
