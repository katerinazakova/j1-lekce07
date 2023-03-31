package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;
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
  void kdyMaSvatek() {
    Svatky svatky = new Svatky();
    assertEquals(MonthDay.of(5, 18), svatky.kdyMaSvatek("Nataša"));
    assertNull(svatky.kdyMaSvatek("Eva"));
    assertNull(svatky.kdyMaSvatek("ghutzjik"));
  }

  @Test
  void kdyMaSvatek_ProVstupNasa_VraciValidniVystup() {
    //Arrange
    Svatky svatky = new Svatky();
    String jmeno = "Nataša";
    int month = 5;
    int dayOfMonth = 18;
    MonthDay expectedResult = MonthDay.of(month, dayOfMonth);
    //Act
    MonthDay actualResult = svatky.kdyMaSvatek(jmeno);

    //Assert
    assertEquals(expectedResult, actualResult);
  }
  @Test
  void kdyMaSvatek_ProVstupEva_VraciNevalidniVystup(){

    //Arrange
    Svatky svatky = new Svatky();
    String jmeno = "Eva";
    //Act
    MonthDay actualResult = svatky.kdyMaSvatek(jmeno);

    //Assert
    assertNull(actualResult);
  }


  /**
   * Testuje metodu {@link Svatky#jeVSeznamu(String)}
   */
  @Test
  void jeVSeznamu_ProVstup_Natasa_ExistujiciJmeno() {
    //TODO Otestovat, že najde v seznamu existující jméno a nenajde neexistující jméno

    //Arrange
    Svatky svatky = new Svatky();
    String jmeno = "Nataša";

    //Act
    Boolean actualResult = svatky.jeVSeznamu(jmeno);

    //Assert
    assertTrue(actualResult);

  }

  @Test
  void jeVSeznamu_ProVstup_Eva_NeexistujiciJmeno(){
    //Arrange
    Svatky svatky = new Svatky();
    String jmeno = "Eva";

    //Act
    Boolean actualResult = svatky.jeVSeznamu(jmeno);

    //Assert
    assertFalse(actualResult);

  }

  /**
   * Testuje metodu {@link Svatky#getPocetJmen()}
   */
  @Test
  void getPocetJmen() {
    //TODO Otestovat, že vrací počet jmen, která máme v seznamu

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
  void getSeznamJmen() {
    //TODO Zkontrolovat, že seznam jmen má správný počet položek.
    //Arrange
    Svatky svatky = new Svatky();
    Set <String> expectedResult =
    //Act
    Set <String> actualResult = svatky.getSeznamJmen();
    //Assert
    assertTrue(Set <String> actualResult);

  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, int, int)}
   */
  @Test
  void pridatSvatekDenMesicInt() {
    //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    //Arrange
    Svatky svatky = new Svatky();
    String jmeno = "Nataša";
    int month = 5;
    int dayOfMonth = 18;
    MonthDay denMesic= MonthDay.of(month, dayOfMonth);
    //Act
    svatky.pridatSvatek(jmeno,denMesic);
    MonthDay datumSvatku = svatky.kdyMaSvatek(jmeno);

    //Assert

  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, int, Month)}
   */
  @Test
  void pridatSvatekDenMesicMonth() {
    Svatky svatky = new Svatky();
    //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    //Arrange

    //Act

    //Assert
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, MonthDay)}
   */
  @Test
  void prridatSvatekMonthDay() {
    Svatky svatky = new Svatky();
    //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    //Arrange

    //Act

    //Assert

  }

  /**
   * Testuje metodu {@link Svatky#smazatSvatek(String)}
   */
  @Test
  void smazatSvatek() {
    Svatky svatky = new Svatky();
    //TODO Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
    //Arrange

    //Act

    //Assert
  }
}
