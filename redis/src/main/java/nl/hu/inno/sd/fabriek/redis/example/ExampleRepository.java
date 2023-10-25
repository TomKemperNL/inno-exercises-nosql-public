package nl.hu.inno.sd.fabriek.redis.example;

import org.springframework.data.repository.CrudRepository;

public interface ExampleRepository extends CrudRepository<Example, String> {
}
