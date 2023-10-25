package nl.hu.inno.sd.fabriek.neo.example;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Collections;
import java.util.List;

@Node("Klant")
public class Example {
    @Id
    @GeneratedValue
    private Long id;

    private String naam;

    private String nr; //Klein bugje in het import script, dit moet daar een int worden... TODO

    private String plaats;
    private String straat;

    @Relationship(type = "Dummyrelatie", direction = Relationship.Direction.OUTGOING)
    private List<ExampleDummy> dummies;

    public Example(String naam, String nr, String plaats, String straat) {
        this.naam = naam;
        this.nr = nr;
        this.plaats = plaats;
        this.straat = straat;
    }

    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getNr() {
        return nr;
    }

    public String getPlaats() {
        return plaats;
    }

    public String getStraat() {
        return straat;
    }

    public List<ExampleDummy> getDummies() {
        return Collections.unmodifiableList(dummies);
    }
}
