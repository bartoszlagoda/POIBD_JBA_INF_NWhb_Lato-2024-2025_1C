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
        koszyk.wyczyscKoszyk();
        koszyk.dodajProdukt("Papier", 2);

        Map<Produkt,Integer> produkty = koszyk.getProdukty();

        assertAll(
                () -> assertEquals(0, produkty.size(), "Nie powinno być produktów w koszyku, a jest ich " + produkty.size())
        );
    }

    @Test
    public void nieDodajeProduktuNiedostepnegoTest(){
        koszyk.wyczyscKoszyk();
        koszyk.dodajProdukt("Jogurt naturalny 150g",1);

        Map<Produkt,Integer> produkty = koszyk.getProdukty();

        assertAll(
                () -> assertEquals(0, produkty.size(), "Nie powinno być produktów w koszyku, a jest ich " + produkty.size())
        );
    }

    @Test
    public void usuwanieProduktuZKoszykaTest(){
        koszyk.wyczyscKoszyk();
        koszyk.dodajProdukt("Mleko 2% 1L", 4);
        Produkt mleko = katalog.znajdzProduktPoNazwie("Mleko 2% 1L");

        koszyk.usunProdukt(mleko);
        koszyk.usunProdukt(mleko);
        koszyk.usunProdukt(mleko);
        koszyk.usunProdukt(mleko);

        assertAll(
                () -> assertTrue(koszyk.getProdukty().isEmpty(), "Koszyk powinien być pusty po usunięciu produktu")
        );
    }

    @Test
    public void cenaCalkowitaDlaWieluProduktowTest(){
        koszyk.wyczyscKoszyk();
        koszyk.dodajProdukt("Mleko 2% 1L",2);
        koszyk.dodajProdukt("Filet z kurczaka 1kg",1);
        koszyk.dodajProdukt("Czekolada mleczna 100g",2);

        double cena = koszyk.obliczCeneCalkowita();

        assertAll(
                () -> assertEquals(28.95,cena,0.001,"Cena koszyka powinna wynosic 28.95")
        );
    }

    @Test
    public void wyswietlanieProduktowwKoszykuTest(){
        koszyk.wyczyscKoszyk();
        koszyk.dodajProdukt("Mleko 2% 1L",1);
        koszyk.dodajProdukt("Filet z kurczaka 1kg",3);

        Map<Produkt,Integer> produkty = koszyk.getProdukty();

        assertAll(
                () -> assertEquals(2,produkty.size(),"W koszyku powinny być 2 róźne artykuły"),
                () -> assertTrue(produkty.keySet().stream().anyMatch(p -> p.getNazwa().equals("Mleko 2% 1L")),"Brakuje produktu: Mleko 2% 1L"),
                () -> assertTrue(produkty.keySet().stream().anyMatch(p -> p.getNazwa().equals("Filet z kurczaka 1kg")),"Brakuje produktu: Filet z kurczaka 1kg")
        );
    }
}
