package nl.hu.inno.sd.fabriek.neo;

import nl.hu.inno.sd.fabriek.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NeoFabriekService implements FabriekService {
    @Override
    public List<KlantDTO> findAllKlanten() {
        return null;
    }

    @Override
    public List<BeschikbaarArtikelDTO> findAllArtikelen() {
        return null;
    }

    @Override
    public List<FabriekDTO> findAllFabrieken() {
        return null;
    }

    @Override
    public List<BestellingDTO> findAllBestellingen() {
        return null;
    }

    @Override
    public void verplaatsVoorraad(BeschikbaarArtikelDTO artikelDTO, int aantal, FabriekDTO van, FabriekDTO naar) {

    }

    @Override
    public void plaatsBestelling(KlantDTO klant, List<BeschikbaarArtikelDTO> artikelen) {

    }
}
