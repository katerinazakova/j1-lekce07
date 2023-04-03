package cz.czechitas.lekce7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

  /**
   * Testuje metodu {@link Svatky#kdyMaSvatek(String)}
   */

  @Test
  void kdyMaSvatek_ProVstupNatasa_VraciValidniVystup() {
    //Arrange
    Svatky svatky = new Svatky();
    String name = "Nataša";
    int month = 5;
    int dayOfMonth = 18;
    MonthDay expectedResult = MonthDay.of(month, dayOfMonth);

    //Act
    MonthDay actualResult = svatky.kdyMaSvatek(name);

    //Assert
    assertEquals(expectedResult, actualResult);
  }
  @Test
  void kdyMaSvatek_ProVstupEva_VraciNevalidniVystup(){
    //Arrange
    Svatky svatky = new Svatky();
    String name = "Eva";

    //Act
    MonthDay actualResult = svatky.kdyMaSvatek(name);

    //Assert
    assertNull(actualResult);
  }

  /**
   * Testuje metodu {@link Svatky#jeVSeznamu(String)}
   */
  @Test
  void jeVSeznamu_ProVstupEmil_VraciTrue() {
    //Arrange
    Svatky svatky = new Svatky();
    String name = "Emil";

    //Act
    boolean actualResult = svatky.jeVSeznamu(name);

    //Assert
    assertTrue(actualResult);
  }

  @Test
  void jeVSeznamu_ProVstupKatka_VraciFalse(){
    //Arrange
    Svatky svatky = new Svatky();
    String name = "Katka";

    //Act
    boolean actualResult = svatky.jeVSeznamu(name);

    //Assert
    assertFalse(actualResult);
  }

  /**
   * Testuje metodu {@link Svatky#getPocetJmen()}
   */
  @Test
  void getPocetJmen_VraciPocetJmenVSeznamu() {
    //Arrange
    Svatky svatky = new Svatky();
    int expectedResult = 37;

    //Act
    int actualResult = svatky.getPocetJmen();

    //Assert
    assertEquals(expectedResult,actualResult);
  }

  /**
   * Testuje metodu {@link Svatky#getSeznamJmen()}
   */

  @Test
  void getSeznamJmen_VraciExistujiciSeznam() {
    //Arrange
    Svatky svatky = new Svatky();

    //Act
    Set <String> actualResult = svatky.getSeznamJmen();

    //Assert
    assertNotNull(actualResult);
  }

  @Test
  void getSeznamJmen_VraciPocetPolozek() {
    //Arrange
    Svatky svatky = new Svatky();
    int expectedResult = 37;

    //Act
    int actualResult = svatky.getSeznamJmen().size();

    //Assert
    assertEquals(expectedResult,actualResult);
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, int, int)}
   */
  @Test
  @DisplayName("Simona, 12.12.")
  void pridatSvatekDenMesicInt_VraciPlatnyDenMesic() {
    //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    //Arrange
    Svatky svatky = new Svatky();
    String name = "Simona";
    int dayOfMonth = 12;
    int month = 12;

    //Act
    svatky.pridatSvatek(name,dayOfMonth,month);
    MonthDay actualResult = svatky.kdyMaSvatek(name);


    // assert
    assertNotNull(actualResult);
    assertEquals(dayOfMonth,actualResult.getDayOfMonth());
    assertEquals(month,actualResult.getMonthValue());
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, int, Month)}
   */
  @Test
  @DisplayName("Alexandr, 27. února")
  void pridatSvatekDenMesicMonth_VraciPlatnyDenMesic() {
    //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    //Arrange
    Svatky svatky = new Svatky();
    String name = "Alexandr";
    int dayOfMonth = 27;
    Month month = Month.FEBRUARY;

    //Act
    svatky.pridatSvatek(name,dayOfMonth, month);
    MonthDay actualResult = svatky.kdyMaSvatek(name);


    //Assert
    assertNotNull(actualResult);
    assertEquals(dayOfMonth,actualResult.getDayOfMonth());
    assertEquals(month,actualResult.getMonth());
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, MonthDay)}
   */
  @Test
  void pridatSvatekMonthDay() {

    //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    //Arrange
    Svatky svatky = new Svatky();
    String name = "Adéla";
    MonthDay monthDay = MonthDay.of(Month.SEPTEMBER,9);
    //Act
    svatky.pridatSvatek(name,monthDay);
    MonthDay actualResult = svatky.kdyMaSvatek(name);

    //Assert
    assertNotNull(actualResult);
    assertEquals(monthDay,actualResult);
  }

  /**
   * Testuje metodu {@link Svatky#smazatSvatek(String)}
   */
  @Test
  void smazatSvatek_VraciNovyPocetSvatku() {
    //Arrange
    Svatky svatky = new Svatky();
    String jmeno = "Kamila";
    int originalCount = 37;
    int expectedResult = originalCount - 1;

    //Act
    svatky.smazatSvatek(jmeno);
    int actualResult = svatky.getSeznamJmen().size();

    //Assert
    assertEquals(expectedResult,actualResult);
  }
}
