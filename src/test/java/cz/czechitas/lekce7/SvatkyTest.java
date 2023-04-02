package cz.czechitas.lekce7;

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
  void kdyMaSvatek_ProVstupNasa_VraciValidniVystup() {
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
  void jeVSeznamu_ProVstupEmil_VraciExistujiciJmeno() {
    //Arrange
    Svatky svatky = new Svatky();
    String name = "Emil";

    //Act
    Boolean actualResult = svatky.jeVSeznamu(name);

    //Assert
    assertTrue(actualResult);
  }

  @Test
  void jeVSeznamu_ProVstupKatka_VraciNeexistujiciJmeno(){
    //Arrange
    Svatky svatky = new Svatky();
    String name = "Katka";

    //Act
    Boolean actualResult = svatky.jeVSeznamu(name);

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
  void pridatSvatekDenMesicInt_ProVstupDen_VraciPlatnyDen() {
    //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    //Arrange
    Svatky svatky = new Svatky();
    String name = "Nataša";
    int dayOfMonth = 18;
    int month = 5;

    //Act
    MonthDay actualResult = svatky.kdyMaSvatek(name);
    svatky.pridatSvatek(name,dayOfMonth,month);

    // assert
    assertNotNull(svatky.kdyMaSvatek(name));
    assertEquals(dayOfMonth,actualResult.getDayOfMonth());
  }
  @Test
  void pridatSvatekDenMesicInt_ProVstupMesic_VraciPlatnyMesic() {
    //Arrange
    Svatky svatky = new Svatky();
    String name = "Nataša";
    int dayOfMonth = 18;
    int month = 5;

    //Act
    MonthDay actualResult = svatky.kdyMaSvatek(name);
    svatky.pridatSvatek(name,dayOfMonth,month);

    // assert
    assertEquals(month,actualResult.getMonthValue());
  }
  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, int, Month)}
   */
  @Test
  void pridatSvatekDenMesicMonth_ProVstupDen_VraciPlatnyDen() {
    //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    //Arrange
    Svatky svatky = new Svatky();
    String name = "Nataša";
    int dayOfMonth = 18;
    Month month = Month.MAY;

    //Act
    MonthDay actualResult = svatky.kdyMaSvatek(name);
    svatky.pridatSvatek(name,dayOfMonth, month);

    //Assert
    assertNotNull(svatky.kdyMaSvatek(name));
    assertEquals(dayOfMonth,actualResult.getDayOfMonth());
  }

  @Test
  void pridatSvatekDenMesicMonth_ProVstupMesic_VraciPlatnyMesic() {
    //Arrange
    Svatky svatky = new Svatky();
    String name = "Nataša";
    int dayOfMonth = 18;
    Month month = Month.MAY;

    //Act
    MonthDay actualResult = svatky.kdyMaSvatek(name);
    svatky.pridatSvatek(name,dayOfMonth, month);

    //Assert
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
    String name = "Nataša";
    int dayOfMonth = 18;
    int month = 5;
    MonthDay monthDay = MonthDay.of(month, dayOfMonth);

    //Act
    MonthDay actualResult = svatky.kdyMaSvatek(name);
    svatky.pridatSvatek(name,monthDay);

    //Assert
    assertNotNull(svatky.kdyMaSvatek(name));
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
    int originalCount = svatky.getSeznamJmen().size();
    int expectedResult = originalCount - 1;

    //Act
    svatky.smazatSvatek(jmeno);
    int actualResult = svatky.getSeznamJmen().size();

    //Assert
    assertEquals(expectedResult,actualResult);
  }
}
