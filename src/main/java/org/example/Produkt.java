package org.example;

public class Produkt {
    private String nazwa;
    private double cena;
    private String kategoria;
    private boolean aktywny;

    public Produkt(String nazwa, double cena, String kategoria, boolean aktywny){
        this.nazwa = nazwa;
        this.cena = cena;
        this.kategoria = kategoria;
        this.aktywny = aktywny;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", kategoria='" + kategoria + '\'' +
                ", aktywny=" + aktywny +
                '}';
    }
}
