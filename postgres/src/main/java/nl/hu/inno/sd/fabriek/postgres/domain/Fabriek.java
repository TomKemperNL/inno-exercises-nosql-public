package nl.hu.inno.sd.fabriek.postgres.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
public class Fabriek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fabnr;

    private String naam;

    private String adres;

    private String plaats;

    @OneToMany(mappedBy = "id.fabnr", fetch = FetchType.EAGER)
    private List<Voorraad> voorraad = new ArrayList<>();

    protected Fabriek(){}

    public Fabriek(String naam, String adres, String plaats) {
        this.naam = naam;
        this.adres = adres;
        this.plaats = plaats;
    }

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

    public Map<Artikel, Voorraad> getVoorraad() {
        return this.voorraad.stream().collect(Collectors.toMap(v -> v.getId().getArtikel(), v->v));
    }
}
