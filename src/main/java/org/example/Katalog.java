package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Katalog {
    private List<Produkt> produkty;

    public Katalog(){
        System.out.println("Konstruktor : Katalog");
        produkty = new ArrayList<>();

        produkty.add(new Produkt("Mleko 2% 1L",3.49,Kategoria.NABIAL,25,true));
        produkty.add(new Produkt("Jogurt naturalny 150g", 1.99, Kategoria.NABIAL, 0, false));
        produkty.add(new Produkt("Filet z kurczaka 1kg", 15.99, Kategoria.MIESO_I_WEDLINY, 12, true));
        produkty.add(new Produkt("Szynka gotowana 200g", 5.29, Kategoria.MIESO_I_WEDLINY, 0, false));
        produkty.add(new Produkt("Jabłka 1kg", 3.99, Kategoria.OWOCE_I_WARZYWA, 45, true));
        produkty.add(new Produkt("Pomarańcze 1kg", 5.49, Kategoria.OWOCE_I_WARZYWA, 0, false));
        produkty.add(new Produkt("Czekolada mleczna 100g", 2.99, Kategoria.SLODYCZE, 60, true));
        produkty.add(new Produkt("Ciastka owsiane 250g", 4.49, Kategoria.SLODYCZE, 10, true));
        produkty.add(new Produkt("Woda mineralna 1.5L", 1.89, Kategoria.NAPOJE, 100, true));
        produkty.add(new Produkt("Sok pomarańczowy 1L", 4.99, Kategoria.NAPOJE, 0, false));
        produkty.add(new Produkt("Płyn do naczyń 500ml", 6.29, Kategoria.CHEMIA_GOSPODARCZA, 34, true));
        produkty.add(new Produkt("Proszek do prania 2kg", 18.99, Kategoria.CHEMIA_GOSPODARCZA, 7, true));
        produkty.add(new Produkt("Chleb pszenny 500g", 3.99, Kategoria.PIECZYWO, 20, true));
        produkty.add(new Produkt("Bułka kajzerka 50g", 0.49, Kategoria.PIECZYWO, 100, true));
        produkty.add(new Produkt("Bagietka 250g", 2.49, Kategoria.PIECZYWO, 30, true));
        produkty.add(new Produkt("Chleb razowy 500g", 4.49, Kategoria.PIECZYWO, 15, true));
        produkty.add(new Produkt("Rogalik 70g", 1.29, Kategoria.PIECZYWO, 50, true));
        produkty.add(new Produkt("Mleko 3.2% 1L", 3.99, Kategoria.NABIAL, 20, true));
        produkty.add(new Produkt("Ser żółty 200g", 6.99, Kategoria.NABIAL, 10, true));
        produkty.add(new Produkt("Kiełbasa wiejska 1kg", 19.99, Kategoria.MIESO_I_WEDLINY, 8, true));
        produkty.add(new Produkt("Banany 1kg", 4.99, Kategoria.OWOCE_I_WARZYWA, 25, true));
        produkty.add(new Produkt("Czekolada gorzka 100g", 3.49, Kategoria.SLODYCZE, 40, true));
        produkty.add(new Produkt("Herbatniki 200g", 2.99, Kategoria.SLODYCZE, 30, true));
        produkty.add(new Produkt("Cola 1.5L", 4.49, Kategoria.NAPOJE, 50, true));

        System.out.println("Zaktualizowano katalog");
    }

    public List<Produkt> getProdukty() {
        return produkty;
    }

    public List<String> wypiszProduktyAlfabetycznie(){
        return produkty.stream()
                .sorted(Comparator.comparing(Produkt::getNazwa))
                .map(Produkt::toString)
                .collect(Collectors.toList());
    }

    public List<String> wypiszProduktyDostepnZKategorii(Kategoria kategoria){
        return produkty.stream()
                .filter(p -> p.isAktywny() && p.getKategoria() == kategoria)
                .sorted(Comparator.comparingDouble(Produkt::getCena))
                .map(Produkt::toString)
                .collect(Collectors.toList());
    }
}
