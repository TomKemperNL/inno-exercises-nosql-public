package nl.hu.inno.sd.fabriek.neo.example;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ExampleRepository extends Neo4jRepository<Example, Long> {
}
