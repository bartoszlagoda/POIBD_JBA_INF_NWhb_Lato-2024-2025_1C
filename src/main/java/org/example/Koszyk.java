package org.example;

import java.util.HashMap;
import java.util.Map;

import static Utils.Logs.logInfo;

public class Koszyk {
    private final Map<Produkt, Integer> produkty;
    private final Katalog katalog;

    public Koszyk(Katalog katalog){
        this.katalog = katalog;
        this.produkty = new HashMap<>();
    }

    public void dodajProdukt(Produkt produkt){
        if(!katalog.zawieraProdukt(produkt)){
            logInfo(produkt.getNazwa() + " nie znajduje sie w katalogu lub jest niedostepny.");
            return;
        }
        produkty.put(produkt, produkty.getOrDefault(produkt, 0) + 1);
    }

    public void usunProdukt(Produkt produkt){
        if(produkty.containsKey(produkt)){
            int ilosc = produkty.get(produkt);
            if (ilosc <= 1){
                produkty.remove(produkt);
            } else {
                produkty.put(produkt, ilosc - 1);
            }
        }
    }

}
