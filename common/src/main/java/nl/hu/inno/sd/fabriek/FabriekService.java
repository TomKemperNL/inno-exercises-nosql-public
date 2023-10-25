package nl.hu.inno.sd.fabriek;

import java.util.List;

public interface FabriekService {
    //Dit zou je in het echt waarschijnlijk opsplitsen in verschillende services
    //omdat we niet alleen 'alles' willen kunnen vinden, maar ook op id, op datum, en weet ik veel wat nog meer...
    //Dan wordt het een beetje te druk in deze interface.
    List<KlantDTO> findAllKlanten();
    List<BeschikbaarArtikelDTO> findAllArtikelen();
    List<FabriekDTO> findAllFabrieken();
    List<BestellingDTO> findAllBestellingen();


    /**
     * Verplaatst de artikelen van de ene naar de andere fabriek
     * Uiteraard mag dit niet als je daarmee onder de minimumvoorraad van de fabriek uit komt.
     */
    void verplaatsVoorraad(BeschikbaarArtikelDTO artikelDTO, int aantal, FabriekDTO van, FabriekDTO naar);

    /**
     * Een bestelling kan gedaan worden als er een fabriek is die de bestelling kan voldoen zonder
     * onder de minimumvoorraad te komen...
     *
     * Uitdaging: Een bestelling kan voldaan worden als er aan voldaan kan worden, mits er per artikel een verplaatsing
     * uitgevoerd kan worden, zonder dat een fabriek onder z'n minimumvoorraad komt
     *
     * Uitdaging-2: En die verplaatsingen mogen niet minder dan 50 items tegelijk verplaatsen, minstens 10 van hetzelfde soort
     * (anders is het de moeite van de verplaatsing niet waard)
     */
    void plaatsBestelling(KlantDTO klant, List<BeschikbaarArtikelDTO> artikelen);
}
