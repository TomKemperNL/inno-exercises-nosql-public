package nl.hu.inno.sd.fabriek.neo;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hu.inno.sd.fabriek.neo.example.Example;
import nl.hu.inno.sd.fabriek.neo.example.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Component;

// Deze file kan weg.
@Component
public class NeoHello implements CommandLineRunner {

    @Autowired
    private Neo4jTemplate neo;

    @Autowired
    private ExampleRepository examples;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Neo4J");
        ObjectMapper jackson = new ObjectMapper();

        System.out.println("Met repositories");
        for(Example e: examples.findAll()){
            System.out.println(jackson.writeValueAsString(e));
        }

        System.out.println("Met Rauwe API");
        for(Example e: neo.findAll("MATCH (k:Klant) WHERE k.naam STARTS WITH 'S' RETURN k", Example.class)){
            System.out.println(jackson.writeValueAsString(e));
        }
    }
}
