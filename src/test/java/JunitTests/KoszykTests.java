package JunitTests;

import org.example.Produkt;
import org.junit.jupiter.api.Test;

public class KoszykTests {
    @Test
    public void KoszykTest(){
        System.out.println("Stworzenie produktów:");
        System.out.println("=====================");
        Produkt marchewka = new Produkt("marchewka",3.99,"warzywo",true);
        System.out.println(marchewka.toString());;
    }
}
