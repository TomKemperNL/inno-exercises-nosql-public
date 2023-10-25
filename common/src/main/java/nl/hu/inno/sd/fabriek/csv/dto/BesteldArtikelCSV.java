package nl.hu.inno.sd.fabriek.csv.dto;

import com.opencsv.bean.CsvBindByName;

public class BesteldArtikelCSV {
    //bestnr,artnr,aantal,bestelprijs

    @CsvBindByName
    private int bestnr;
    @CsvBindByName
    private int artnr;
    @CsvBindByName
    private int aantal;
    @CsvBindByName
    private double bestelprijs;

    public int getBestnr() {
        return bestnr;
    }

    public int getArtnr() {
        return artnr;
    }

    public int getAantal() {
        return aantal;
    }

    public double getBestelprijs() {
        return bestelprijs;
    }
}
