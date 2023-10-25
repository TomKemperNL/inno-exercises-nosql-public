package nl.hu.inno.sd.fabriek.redis.example;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("examples")
public class Example {
    @Id
    private String klantnr;
    private String naam;
    private String adres;
    private String plaats;

    public Example(String klantnr, String naam, String adres, String plaats) {
        this.klantnr = klantnr;
        this.naam = naam;
        this.adres = adres;
        this.plaats = plaats;
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
