package nl.hu.inno.sd.fabriek.csv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;
import nl.hu.inno.sd.fabriek.csv.dto.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvReader {

    private static <T> List<T> readObjects(String path, Class<T> clz) throws FileNotFoundException {
        List<T> beans = new CsvToBeanBuilder(new FileReader(path))
                .withType(clz).build().parse();
        return beans;
    }

    public static List<ArtikelCSV> readArtikelen() throws FileNotFoundException {
        return readObjects("./csv/artikel.csv", ArtikelCSV.class);
    }

    public static List<KlantCSV> readKlanten() throws FileNotFoundException {
        return readObjects("./csv/klant.csv", KlantCSV.class);
    }

    public static List<BesteldArtikelCSV> readBesteldArtikel() throws FileNotFoundException {
        return readObjects("./csv/besteldartikel.csv", BesteldArtikelCSV.class);
    }

    public static List<BestellingCSV> readBestellingen() throws FileNotFoundException {
        return readObjects("./csv/bestelling.csv", BestellingCSV.class);
    }

    public static List<FabriekCSV> readFabrieken() throws FileNotFoundException {
        return readObjects("./csv/fabriek.csv", FabriekCSV.class);
    }

    public static List<VoorraadCSV> readVoorraad() throws FileNotFoundException {
        return readObjects("./csv/voorraad.csv", VoorraadCSV.class);
    }

    public static void main(String[] args) throws FileNotFoundException, JsonProcessingException {
        //Testmain
        ObjectMapper objectMapper = new ObjectMapper();

        for (ArtikelCSV art : readArtikelen()) {
            System.out.println(objectMapper.writeValueAsString(art));
        }

        for (KlantCSV k : readKlanten()) {
            System.out.println(objectMapper.writeValueAsString(k));
        }

        for (FabriekCSV f : readFabrieken()) {
            System.out.println(objectMapper.writeValueAsString(f));
        }

        for (BestellingCSV b : readBestellingen()) {
            System.out.println(objectMapper.writeValueAsString(b));
        }

        for (BesteldArtikelCSV ba : readBesteldArtikel()) {
            System.out.println(objectMapper.writeValueAsString(ba));
        }

        for (VoorraadCSV v : readVoorraad()) {
            System.out.println(objectMapper.writeValueAsString(v));
        }
    }
}
