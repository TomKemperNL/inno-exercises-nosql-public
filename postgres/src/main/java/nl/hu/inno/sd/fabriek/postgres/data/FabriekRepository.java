package nl.hu.inno.sd.fabriek.postgres.data;

import nl.hu.inno.sd.fabriek.postgres.domain.Fabriek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabriekRepository extends JpaRepository<Fabriek, Integer> {
}
