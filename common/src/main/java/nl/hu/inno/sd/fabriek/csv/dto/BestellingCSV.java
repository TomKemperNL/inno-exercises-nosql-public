package nl.hu.inno.sd.fabriek.csv.dto;

import com.opencsv.bean.CsvBindByName;

public class BestellingCSV {
    //bestnr,klantnr,fabnr,datum
    @CsvBindByName
    private int bestnr;
    @CsvBindByName
    private int klantnr;
    @CsvBindByName
    private int fabnr;
    @CsvBindByName
    private String datum;

    public int getBestnr() {
        return bestnr;
    }

    public int getKlantnr() {
        return klantnr;
    }

    public int getFabnr() {
        return fabnr;
    }

    public String getDatum() {
        return datum;
    }
}
