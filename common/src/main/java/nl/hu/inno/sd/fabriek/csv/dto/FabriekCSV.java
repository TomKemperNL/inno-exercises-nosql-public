package nl.hu.inno.sd.fabriek.csv.dto;

import com.opencsv.bean.CsvBindByName;

public class FabriekCSV {
    //fabnr,naam,adres,plaats

    @CsvBindByName
    private int fabnr;
    @CsvBindByName
    private String naam;
    @CsvBindByName
    private String adres;
    @CsvBindByName
    private String plaats;

    public int getFabnr() {
        return fabnr;
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
