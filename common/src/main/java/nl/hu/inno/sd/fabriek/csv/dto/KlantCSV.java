package nl.hu.inno.sd.fabriek.csv.dto;

import com.opencsv.bean.CsvBindByName;

public class KlantCSV {

    @CsvBindByName
    private int klantNr;
    @CsvBindByName
    private String naam;
    @CsvBindByName
    private String adres;
    @CsvBindByName
    private String plaats;

    public int getKlantNr() {
        return klantNr;
    }

    public String getNaam() {
        return naam;
    }

    public String getAdres() {
        return adres;
    }

    public String getPlaats() {
        return plaats;
    }
}
