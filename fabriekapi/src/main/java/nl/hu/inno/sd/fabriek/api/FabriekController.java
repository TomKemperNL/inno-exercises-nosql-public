package nl.hu.inno.sd.fabriek.api;

import nl.hu.inno.sd.fabriek.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FabriekController {

    private final FabriekService service;

    public FabriekController(FabriekService services){
        this.service = services;
    }

    @GetMapping("/klanten")
    public List<KlantDTO> getKlanten(){
        return service.findAllKlanten();
    }

    @GetMapping("/fabrieken")
    public List<FabriekDTO> getFabrieken(){
        return service.findAllFabrieken();
    }

    @GetMapping("/artikelen")
    public List<BeschikbaarArtikelDTO> getArtikelen(){
        return service.findAllArtikelen();
    }

    @GetMapping("/bestellingen")
    public List<BestellingDTO> getBestellingen(){
        return service.findAllBestellingen();
    }
}
