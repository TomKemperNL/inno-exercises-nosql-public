package nl.hu.inno.sd.fabriek.postgres.domain;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
class PersistenceTets {

    @Autowired
    private EntityManager entities;

    @Test
    public void canPersistFabriek(){
        Fabriek fb = new Fabriek("Bla", "Bla", "Bla");

        entities.persist(fb);
    }


    @Test
    public void canQueryAll(){
        this.entities.createQuery("select f from Fabriek f").getResultList();
        this.entities.createQuery("select a from Artikel a").getResultList();
        this.entities.createQuery("select b from Bestelling b").getResultList();
        this.entities.createQuery("select k from Klant k").getResultList();
    }
}
