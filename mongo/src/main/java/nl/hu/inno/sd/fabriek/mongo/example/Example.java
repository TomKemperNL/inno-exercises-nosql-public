package nl.hu.inno.sd.fabriek.mongo.example;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="import_demo")
public class Example {
    private ObjectId _id;

    private String klantnr;
    private String naam;
    private String adres;
    private String plaats;

    protected Example(){}
    public Example(String klantnr, String naam, String adres, String plaats) {
        this.klantnr = klantnr;
        this.naam = naam;
        this.adres = adres;
        this.plaats = plaats;
    }

    public ObjectId get_id() {
        return _id;
    }

    public String getKlantnr() {
        return klantnr;
    }

    public String getNaam() {
        return naam;
    }

    public String getAdres() {
        return adres;
    }

    public String getPlaats() {
        return plaats;
    }
}
