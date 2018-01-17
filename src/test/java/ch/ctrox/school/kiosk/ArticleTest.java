package ch.ctrox.school.kiosk;

import org.junit.Test;

import ch.ctrox.school.kiosk.business.products.Product;
import ch.ctrox.school.kiosk.business.products.StrongAlcohol;

/**
 * @author Cyrill Troxler <cyrilltroxler@gmail.com>
 * @since 12/09/17
 */

public class ArticleTest {
  @Test
  public void testArticle() {
    Product vodka = new StrongAlcohol("Vodka");
    if (vodka.requiresAgeCheck()) {
      System.out.println("You are not " + vodka.getRequiredAge() + " years old");
    }
  }
}