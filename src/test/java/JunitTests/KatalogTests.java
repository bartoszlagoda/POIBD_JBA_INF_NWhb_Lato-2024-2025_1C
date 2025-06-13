package JunitTests;

import org.example.Katalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KatalogTests {

    private Katalog katalog;

    @BeforeEach
    void setUp() {
        katalog = new Katalog();
    }

    @Test
    public void wyswietlNazwyICenyWszystkichProduktowMozliwychDoKupieniaWSklepieTest() {
        List<String> produkty = katalog.wypiszProduktyAlfabetycznie();
        assertAll(
                () -> assertEquals("Bagietka 250g - 2.49 zł", produkty.get(0), "Expected : Bagietka 250g - 2.49 zł | Actual : " + produkty.get(0)),
                () -> assertEquals("Woda mineralna 1.5L - 1.89 zł", produkty.get(produkty.size() - 1), "Expected : Woda mineralna 1.5L - 1.89 zł | Actual : " + produkty.get(produkty.size() - 1))
        );
    }


}
