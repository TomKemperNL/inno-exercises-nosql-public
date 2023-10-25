package nl.hu.inno.sd.fabriek.postgres.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Artikel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artnr;

    private String naam;

    private double adviesprijs;

    protected Artikel(){}

    public Artikel(String naam, double adviesprijs) {
        this.naam = naam;
        this.adviesprijs = adviesprijs;
    }

    public int getArtnr() {
        return artnr;
    }

    public String getNaam() {
        return naam;
    }

    public double getAdviesprijs() {
        return adviesprijs;
    }
}
