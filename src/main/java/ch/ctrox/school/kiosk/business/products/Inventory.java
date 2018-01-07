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

  public Product get(int i) {
    return this.list.get(i);
  }

  public double getTotalPrice() {
    double total = 0d;
    for (Product product: this.list.values()) {
      total += product.getPrice() * product.getCount();
    }
    return total;
  }


}
