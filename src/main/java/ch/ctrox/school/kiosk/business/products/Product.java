package ch.ctrox.school.kiosk.business.products;

import java.util.List;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 21/09/17
 */
public interface Product {
  String getName();

  String getDescription();

  void setDescription(String description);

  int getId();

  void setId(int id);

  double getPrice();

  void setPrice(double price);

  boolean requiresAgeCheck();

  int getRequiredAge();


}
