package nl.hu.inno.sd.fabriek.neo.example;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Dummy")
public class ExampleDummy {

    @Id
    @GeneratedValue
    private Long id;

    private String message;

    public ExampleDummy(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
