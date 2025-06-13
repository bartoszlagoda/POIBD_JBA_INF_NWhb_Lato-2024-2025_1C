package JunitTests;

import org.example.Katalog;
import org.example.Koszyk;
import org.example.Produkt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class KoszykTests {

    private Katalog katalog;
    private Koszyk koszyk;

    @BeforeEach
    void setUp(){
        katalog = new Katalog();
        koszyk = new Koszyk(katalog);
    }

    @Test
    public void dodajProduktPoprawyTest(){
        String nazwaProduktu = "Jabłka 1kg";
        int ilosc = 3;

        koszyk.dodajProdukt(nazwaProduktu, ilosc);

        Map<Produkt,Integer> produkty = koszyk.getProdukty();
        Produkt jablko = katalog.znajdzProduktPoNazwie(nazwaProduktu);

        assertAll(
                () -> assertEquals(1, produkty.size(), "W koszyku powinien być 1 rodzaj produktu, a jest " + produkty.size()),
                () -> assertTrue(produkty.containsKey(jablko), "Koszyk powinien zawierać jabłko"),
                () -> assertEquals(3, produkty.get(jablko), "Powinny być 3 jabłka w koszyku, a jest " + produkty.get(jablko)),
                () -> assertEquals(11.97, koszyk.obliczCeneCalkowita(), 0.01, "Cena powinna wynosić 3 * 3.99 = 11.97 zł, a wynosi: " + koszyk.obliczCeneCalkowita())
        );
    }

    @Test
    public void nieDodajeProduktuSpozaKataloguTest(){
        koszyk.wyswietlZawartosc();
        koszyk.wyczyscKoszyk();
        koszyk.dodajProdukt("Papier", 2);

        Map<Produkt,Integer> produkty = koszyk.getProdukty();
        assertEquals(0, produkty.size(), "Nie powinno być produktów w koszyku, a jest ich" + produkty.size());
    }
}
