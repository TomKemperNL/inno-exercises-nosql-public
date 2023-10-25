package nl.hu.inno.sd.fabriek.scylla;

import com.datastax.oss.driver.api.core.cql.Statement;
import com.datastax.oss.driver.internal.core.cql.DefaultSimpleStatement;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hu.inno.sd.fabriek.csv.CsvReader;
import nl.hu.inno.sd.fabriek.csv.dto.KlantCSV;
import nl.hu.inno.sd.fabriek.scylla.example.Example;
import nl.hu.inno.sd.fabriek.scylla.example.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// Deze file kan weg. Puur een kleine demo om hello world te tonen
public class ScyllaHello implements CommandLineRunner {

    private CassandraTemplate rawApi;
    private ExampleRepository examples;

    public ScyllaHello(CassandraTemplate rawApi, ExampleRepository examples) {
        this.rawApi = rawApi;
        this.examples = examples;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running Scylla Hello world!");

        for (KlantCSV csv : CsvReader.readKlanten()) {
            examples.save(new Example(String.valueOf(csv.getKlantNr()), csv.getNaam(), csv.getNaam(), csv.getPlaats()));
        }

        ObjectMapper om = new ObjectMapper();
        for (Example e : examples.findAll()) {
            System.out.println(om.writeValueAsString(e));
        }


    }
}
