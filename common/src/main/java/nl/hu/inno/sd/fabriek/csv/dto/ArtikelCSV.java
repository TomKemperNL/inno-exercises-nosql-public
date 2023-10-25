package nl.hu.inno.sd.fabriek.csv.dto;

import com.opencsv.bean.CsvBindByName;

public class ArtikelCSV {
    @CsvBindByName
    private Integer artnr;
    @CsvBindByName
    private String naam;
    @CsvBindByName
    private Double adviesprijs;

    public Integer getArtnr() {
        return artnr;
    }

    public String getNaam() {
        return naam;
    }

    public Double getAdviesprijs() {
        return adviesprijs;
    }
}
