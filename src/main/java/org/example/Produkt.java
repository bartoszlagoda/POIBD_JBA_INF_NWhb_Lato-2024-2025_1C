package org.example;

public class Produkt {
    private String nazwa;
    private double cena;
    private Kategoria kategoria;
    private int stan;
    private boolean aktywny;

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public int getStan() {
        return stan;
    }

    public boolean isAktywny() {
        return aktywny;
    }

    public Produkt(String nazwa, double cena, Kategoria kategoria, int stan, boolean aktywny){
        this.nazwa = nazwa;
        this.cena = cena;
        this.kategoria = kategoria;
        this.stan = stan;
        this.aktywny = aktywny;
    }

    @Override
    public String toString() {
        return nazwa + " - " + cena + " zł";
    }
}
