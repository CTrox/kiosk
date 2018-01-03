package ch.ctrox.school.kiosk.business.products;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */
abstract class AbstractProduct implements Product {
  private String name;
  private String description;
  private int id;
  private double price;

  AbstractProduct(String name) {
    this.name = name;
  }

  AbstractProduct() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean requiresAgeCheck() {
    return false;
  }

  public int getRequiredAge() {
    return 0;
  }

}
