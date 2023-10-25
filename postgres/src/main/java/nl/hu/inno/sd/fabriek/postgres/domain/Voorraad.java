package nl.hu.inno.sd.fabriek.postgres.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Voorraad {

    @EmbeddedId
    private Id id;

    private int vrd;

    private int minvrd;

    protected Voorraad() {
    }

    public Voorraad(Fabriek fabriek, Artikel artikel, int vrd, int minvrd) {
        this.id = new Id(fabriek, artikel);
        this.vrd = vrd;
        this.minvrd = minvrd;
    }

    public Id getId() {
        return id;
    }

    public int getVrd() {
        return vrd;
    }

    public int getMinvrd() {
        return minvrd;
    }

    @Embeddable
    public static class Id implements Serializable {
        @ManyToOne
        @JoinColumn(name="fabnr")
        private Fabriek fabnr;
        @ManyToOne
        @JoinColumn(name="artnr")
        private Artikel artnr;

        protected Id() {
        }

        public Id(Fabriek fabriek, Artikel artikel) {
            this.fabnr = fabriek;
            this.artnr = artikel;
        }

        public Fabriek getFabriek() {
            return fabnr;
        }

        public Artikel getArtikel() {
            return artnr;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return fabnr.equals(id.fabnr) && artnr.equals(id.artnr);
        }

        @Override
        public int hashCode() {
            return Objects.hash(fabnr, artnr);
        }
    }
}
