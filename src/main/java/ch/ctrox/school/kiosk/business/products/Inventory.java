package ch.ctrox.school.kiosk.business.products;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory {
  private List<Product> list;

  public Inventory() {
    this.list = new ArrayList<>();
  }

  public List<Product> getList() {
    return list;
  }

  public void add(Product product) {
    this.list.add(product);
  }

  public Product get(int i) {
    return this.list.get(i);
  }

  public double getTotalPrice() {
    double total = 0d;
    for (Product product: this.list) {
      total += product.getPrice();
    }
    return total;
  }

  public int getCount(Product product) {
    return Collections.frequency(this.list, product.getId());
  }


}
