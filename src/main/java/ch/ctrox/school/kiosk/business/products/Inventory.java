package ch.ctrox.school.kiosk.business.products;

import java.util.Collection;
import java.util.HashMap;

public class Inventory {
  private HashMap<Integer, Product> list;

  public Inventory() {
    this.list = new HashMap<>();
  }

  public Collection<Product> getList() {
    return list.values();
  }

  /**
   * Adds a product to the inventory using product.id as the key
   * @param product the product object to add
   */
  public void add(Product product) {
    if (this.list.containsKey(product.getId())) {
      // Increment count if product is already in inventory
      this.list.get(product.getId()).addCount();
    } else {
      if (product.getCount() == 0) {
        // set initial count
        product.addCount();
      }
      this.list.put(product.getId(), product);
    }
  }

  /**
   * Gets a product by id
   * @param id of the id
   * @return the requested product
   */
  public Product get(int id) {
    return this.list.get(id);
  }

  /**
   * Calculates the total price of all products of the inventory
   * @return a double value of the price
   */
  public double getTotalPrice() {
    double total = 0d;
    for (Product product: this.list.values()) {
      total += product.getPrice() * product.getCount();
    }
    return total;
  }

  /**
   * Gets a product by name
   * @param name of the product
   * @return the requested product
   */
  public Product getByName(String name) {
    for (Product product: this.list.values()) {
      if (product.getName().equals(name)) {
        return product;
      }
    }
    return null;
  }

}
