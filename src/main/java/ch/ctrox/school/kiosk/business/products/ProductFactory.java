package ch.ctrox.school.kiosk.business.products;

public class ProductFactory {
  public static Product build(String category) {
    if (category.equals("LightAlcohol")) {
      return new LightAlcohol();
    }
    if (category.equals("StrongAlcohol")) {
      return new StrongAlcohol();
    }
    if (category.equals("Magazine")) {
      return new Magazine();
    }
    if (category.equals("Snack")) {
      return new Snack();
    }
    if (category.equals("SoftDrink")) {
      return new SoftDrink();
    }
    if (category.equals("Tobacco")) {
      return new Tobacco();
    }
    return null;
  }
}
