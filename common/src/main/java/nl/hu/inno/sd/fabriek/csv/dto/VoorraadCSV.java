package nl.hu.inno.sd.fabriek.csv.dto;

import com.opencsv.bean.CsvBindByName;

public class VoorraadCSV {
    //fabnr,artnr,vrd,minvrd

    @CsvBindByName
    private int fabnr;
    @CsvBindByName
    private int artnr;
    @CsvBindByName
    private int vrd;
    @CsvBindByName
    private int minvrd;

    public int getFabnr() {
        return fabnr;
    }

    public int getArtnr() {
        return artnr;
    }

    public int getVrd() {
        return vrd;
    }

    public int getMinvrd() {
        return minvrd;
    }
}
