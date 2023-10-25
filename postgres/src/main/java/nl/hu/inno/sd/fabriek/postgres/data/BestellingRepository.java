package nl.hu.inno.sd.fabriek.postgres.data;

import nl.hu.inno.sd.fabriek.postgres.domain.Bestelling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BestellingRepository extends JpaRepository<Bestelling, Integer> {
}
