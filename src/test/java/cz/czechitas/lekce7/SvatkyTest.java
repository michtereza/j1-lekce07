package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        //TODO Otestovat, že najde v seznamu existující jméno a nenajde neexistující jméno
        Svatky svatky = new Svatky();
        assertEquals(true, svatky.jeVSeznamu("Klaudia"));
        assertEquals(false, svatky.jeVSeznamu("Tereza"));
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        //TODO Otestovat, že vrací počet jmen, která máme v seznamu
        Svatky svatky = new Svatky();
       assertEquals(37, svatky.getPocetJmen());

       svatky.pridejSvatek("Tereza", MonthDay.of(10, 15));
       assertEquals(38, svatky.getPocetJmen());

    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        //TODO Zkontrolovat, že seznam jmen má správný počet položek.
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getSeznamJmen().size());
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Tereza", 15,10);
        assertEquals( true, svatky.jeVSeznamu("Tereza"));
        assertEquals(MonthDay.of(10,15), svatky.vratKdyMaSvatek("Tereza"));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Tereza", 15, Month.of(10));
        assertEquals( true, svatky.jeVSeznamu("Tereza"));
        assertEquals(MonthDay.of(10,15), svatky.vratKdyMaSvatek("Tereza"));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void prridatSvatekMonthDay() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Tereza", MonthDay.of(10, 15));
        assertEquals( true, svatky.jeVSeznamu("Tereza"));
        assertEquals(MonthDay.of(10,15), svatky.vratKdyMaSvatek("Tereza"));
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        //TODO Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
        Svatky svatky = new Svatky();
        svatky.smazSvatek("Aneta");
        assertEquals( false, svatky.jeVSeznamu("Aneta"));
        assertEquals(36, svatky.getPocetJmen());
    }
}
