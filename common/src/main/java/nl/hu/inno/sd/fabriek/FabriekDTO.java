package nl.hu.inno.sd.fabriek;

import java.util.List;

public record FabriekDTO(
        String id,
        String naam,
        String adresregel,
        List<VoorraadArtikelDTO> voorraad,
        List<VoorraadArtikelDTO> minVoorraad) {
}
