package org.example;

import java.util.HashMap;
import java.util.Map;

import static Utils.Logs.logInfo;

public class Koszyk {
    private final Map<Produkt, Integer> produkty;
    private final Katalog katalog;

    public Koszyk(Katalog katalog){
        logInfo("================= TWÓJ KOSZYK ====================");
        this.katalog = katalog;
        this.produkty = new HashMap<>();
    }

    public void dodajProdukt(String nazwa, int ilosc){
        Produkt produkt = katalog.znajdzProduktPoNazwie(nazwa);

        if(produkt == null){
            logInfo(nazwa + " nie istnieje w katalogu lub jest niedostępna/y");
            return;
        }
        produkty.put(produkt, produkty.getOrDefault(produkt,0) + ilosc);
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

    public void wyswietlZawartosc(){
        if (produkty.isEmpty()){
            logInfo("Koszyk jest pusty");
            return;
        }
        produkty.forEach((produkt, ilosc) -> logInfo(produkt.getNazwa() + ", " + ilosc + " szt."));
    }

    public double obliczCeneCalkowita(){
        return produkty.entrySet().stream().mapToDouble(e -> e.getKey().getCena() * e.getValue())
                .sum();
    }

    public void wyczyscKoszyk(){
        produkty.clear();
        logInfo("Koszyk został wyczyszczony.");
    }

    public Map<Produkt, Integer> getProdukty(){
        return produkty;
    }

}
