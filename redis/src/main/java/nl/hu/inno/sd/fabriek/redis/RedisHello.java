package nl.hu.inno.sd.fabriek.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hu.inno.sd.fabriek.csv.CsvReader;
import nl.hu.inno.sd.fabriek.csv.dto.KlantCSV;
import nl.hu.inno.sd.fabriek.redis.example.Example;
import nl.hu.inno.sd.fabriek.redis.example.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// Deze file kan weg. Puur een kleine demo om hello world te tonen
public class RedisHello implements CommandLineRunner {

    @Autowired
    private ExampleRepository examples;

    @Override
    public void run(String... args) throws Exception {
        List<Example> examplesRetrieved = new ArrayList<>();
        for (Example e : examples.findAll()) {
            examplesRetrieved.add(e);
        }

        if (examplesRetrieved.size() == 0) {
            for (KlantCSV csv : CsvReader.readKlanten()) {
                examples.save(new Example(String.valueOf(csv.getKlantNr()), csv.getNaam(), csv.getNaam(), csv.getPlaats()));
            }
        }

        ObjectMapper om = new ObjectMapper();
        for (Example e : examples.findAll()) {
            System.out.println(om.writeValueAsString(e));
        }
    }
}
