package nl.hu.inno.sd.fabriek;

import java.util.List;

public record BestellingDTO(String id, KlantDTO klant, List<BesteldArtikelDTO> artikelen) {
}
