package nl.hu.inno.sd.fabriek.postgres;

import nl.hu.inno.sd.fabriek.*;

import nl.hu.inno.sd.fabriek.postgres.data.ArtikelRepository;
import nl.hu.inno.sd.fabriek.postgres.data.BestellingRepository;
import nl.hu.inno.sd.fabriek.postgres.data.FabriekRepository;
import nl.hu.inno.sd.fabriek.postgres.data.KlantRepository;
import nl.hu.inno.sd.fabriek.postgres.domain.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JpaFabriekService implements FabriekService {

    private final KlantRepository klanten;
    private final BestellingRepository bestellingen;
    private final FabriekRepository fabrieken;
    private final ArtikelRepository artikelen;

    public JpaFabriekService(
            KlantRepository klanten,
            BestellingRepository bestellingen,
            FabriekRepository fabrieken,
            ArtikelRepository artikelen) {
        this.klanten = klanten;
        this.bestellingen = bestellingen;
        this.fabrieken = fabrieken;
        this.artikelen = artikelen;
    }

    private KlantDTO toDTO(Klant klant) {
        return new KlantDTO(
                String.valueOf(klant.getKlantnr()),
                klant.getNaam(),
                String.format("%s, %s", klant.getAdres(), klant.getPlaats())
        );
    }

    private BeschikbaarArtikelDTO toDTO(Artikel artikel) {
        return new BeschikbaarArtikelDTO(
                String.valueOf(artikel.getArtnr()), artikel.getNaam(), artikel.getAdviesprijs());
    }


    private FabriekDTO toDTO(Fabriek fabriek) {
        List<VoorraadArtikelDTO> vrd = new ArrayList<>();
        List<VoorraadArtikelDTO> mins = new ArrayList<>();

        for (var item : fabriek.getVoorraad().entrySet()) {
            vrd.add(
                    new VoorraadArtikelDTO(
                            String.valueOf(item.getKey().getArtnr()),
                            item.getKey().getNaam(),
                            item.getValue().getVrd()));
            mins.add(
                    new VoorraadArtikelDTO(
                            String.valueOf(item.getKey().getArtnr()),
                            item.getKey().getNaam(),
                            item.getValue().getMinvrd()));
        }

        return new FabriekDTO(
                String.valueOf(fabriek.getFabnr()),
                fabriek.getNaam(),
                String.format("%s, %s", fabriek.getAdres(), fabriek.getPlaats()),
                vrd, mins);
    }

    @Override
    public List<KlantDTO> findAllKlanten() {
        return this.klanten.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public List<BeschikbaarArtikelDTO> findAllArtikelen() {
        return this.artikelen.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public List<FabriekDTO> findAllFabrieken() {
        return this.fabrieken.findAll().stream().map(this::toDTO).toList();
    }


    @Override
    public List<BestellingDTO> findAllBestellingen() {
        return this.bestellingen.findAll().stream().map(this::toDTO).toList();
    }

    private BestellingDTO toDTO(Bestelling bestelling) {
        List<BesteldArtikelDTO> artikelen = new ArrayList<>();

        for (BesteldArtikel b : bestelling.getArtikelen()) {
            artikelen.add(new BesteldArtikelDTO(
                    String.valueOf(b.getId().getArtnr().getArtnr()),
                    b.getId().getArtnr().getNaam(),
                    b.getAantal(),
                    b.getBestelprijs()));
        }

        return new BestellingDTO(
                String.valueOf(bestelling.getBestnr()), toDTO(bestelling.getKlant()), artikelen);
    }

    @Override
    public void verplaatsVoorraad(BeschikbaarArtikelDTO artikelDTO, int aantal, FabriekDTO van, FabriekDTO naar) {

    }

    @Override
    public void plaatsBestelling(KlantDTO klant, List<BeschikbaarArtikelDTO> artikelen) {

    }
}
