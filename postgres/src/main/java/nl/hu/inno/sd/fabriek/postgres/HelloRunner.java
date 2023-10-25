package nl.hu.inno.sd.fabriek.postgres;

import nl.hu.inno.sd.fabriek.csv.CsvReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Het is niet nodig maar ik zou hier gewoon CSVs kunnen importeren");

        System.out.println(CsvReader.readKlanten().get(0).getNaam());
    }
}
