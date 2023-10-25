package nl.hu.inno.sd.fabriek.mongo;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hu.inno.sd.fabriek.mongo.example.Example;
import nl.hu.inno.sd.fabriek.mongo.example.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
// Deze file kan weg. Het is puur een hello-world-level voorbeeldje
public class MongoHello implements CommandLineRunner {

    @Autowired
    private ExampleRepository examples; //Repositories zoals je gewend bent

    @Autowired
    private MongoTemplate mongo; //Een 'rauwere' API

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MongoDb!");
        ObjectMapper jackson = new ObjectMapper();
        for(Example e: examples.findAll()){
            System.out.println(jackson.writeValueAsString(e));
        }
//        examples.insert(new Example("bla", "bla",  "bla", "bla"));

        //Je ziet dat omdat Mongo een object-database is, dat de rauwe API zo gek nog niet is!
        for(Example e: mongo.findAll(Example.class)){
            System.out.println(jackson.writeValueAsString(e));
        }
    }
}
