package nl.hu.inno.sd.fabriek.postgres.domain;

import jakarta.persistence.*;
import nl.hu.inno.sd.fabriek.BestellingDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Bestelling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bestnr;

    @ManyToOne
    @JoinColumn(name = "klantnr")
    private Klant klant;

    @ManyToOne
    @JoinColumn(name = "fabnr")
    private Fabriek fabriek;

    @OneToMany(mappedBy = "id.bestnr", fetch = FetchType.EAGER)
    private List<BesteldArtikel> artikelen = new ArrayList<>();

    private LocalDate datum;

    protected Bestelling() {
    }

    public Bestelling(Klant klant, Fabriek fabriek, LocalDate date) {
        this.klant = klant;
        this.fabriek = fabriek;
        this.datum = date;
    }

    public int getBestnr() {
        return bestnr;
    }

    public Klant getKlant() {
        return klant;
    }

    public Fabriek getFabriek() {
        return fabriek;
    }

    public LocalDate getDate() {
        return datum;
    }

    public List<BesteldArtikel> getArtikelen() {
        return Collections.unmodifiableList(artikelen);
    }
}
