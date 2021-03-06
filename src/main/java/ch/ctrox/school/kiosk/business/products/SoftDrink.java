package ch.ctrox.school.kiosk.business.products;

/**
 * The SoftDrink product
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 21/09/17
 */
public class SoftDrink extends AbstractProduct {
  // specifies amount of beverage in decilitres
  private int amountInDCL;

  public SoftDrink(String name) {
    super(name);
  }

  public SoftDrink() {
    super();
  }

  public int getAmountInDCL() {
    return amountInDCL;
  }

  public void setAmountInDCL(int amountInDCL) {
    this.amountInDCL = amountInDCL;
  }
}
