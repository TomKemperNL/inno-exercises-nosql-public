package nl.hu.inno.sd.fabriek.postgres.data;

import nl.hu.inno.sd.fabriek.postgres.domain.Artikel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtikelRepository extends JpaRepository<Artikel, Integer> {}
