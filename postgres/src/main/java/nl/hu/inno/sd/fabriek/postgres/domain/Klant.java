package nl.hu.inno.sd.fabriek.postgres.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Klant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int klantnr;

    private String naam;

    private String adres;

    private String plaats;

    protected Klant(){}

    public Klant(String naam, String adres, String plaats) {
        this.naam = naam;
        this.adres = adres;
        this.plaats = plaats;
    }

    public int getKlantnr() {
        return klantnr;
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
