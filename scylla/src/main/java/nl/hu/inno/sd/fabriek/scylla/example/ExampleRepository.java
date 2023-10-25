package nl.hu.inno.sd.fabriek.scylla.example;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ExampleRepository extends CassandraRepository<Example, Long> {
}
