package nl.hu.inno.sd.fabriek.postgres.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "besteldartikel")
public class BesteldArtikel {


    @EmbeddedId
    private Id id;

    private int aantal;

    private double bestelprijs;

    protected BesteldArtikel() {
    }

    public BesteldArtikel(Bestelling bestelling, Artikel artikel, int aantal, double bestelprijs) {
        this.id = new Id(bestelling, artikel);
        this.aantal = aantal;
        this.bestelprijs = bestelprijs;
    }

    public Id getId() {
        return id;
    }

    public int getAantal() {
        return aantal;
    }

    public double getBestelprijs() {
        return bestelprijs;
    }

    @Embeddable
    public static class Id implements Serializable {
        @ManyToOne
        @JoinColumn(name="bestnr")
        private Bestelling bestnr;
        @ManyToOne
        @JoinColumn(name="artnr")
        private Artikel artnr;

        protected Id() {
        }

        public Id(Bestelling bestelling, Artikel artikel) {
            this.bestnr = bestelling;
            this.artnr = artikel;
        }

        public Bestelling getBestnr() {
            return bestnr;
        }

        public Artikel getArtnr() {
            return artnr;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return bestnr.equals(id.bestnr) && artnr.equals(id.artnr);
        }

        @Override
        public int hashCode() {
            return Objects.hash(bestnr, artnr);
        }
    }
}
