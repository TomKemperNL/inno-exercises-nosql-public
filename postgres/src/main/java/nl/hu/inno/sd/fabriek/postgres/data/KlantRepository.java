package nl.hu.inno.sd.fabriek.postgres.data;

import nl.hu.inno.sd.fabriek.postgres.domain.Klant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlantRepository extends JpaRepository<Klant, Integer> {}
