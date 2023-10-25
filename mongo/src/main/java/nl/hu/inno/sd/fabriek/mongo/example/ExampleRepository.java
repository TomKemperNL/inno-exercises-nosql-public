package nl.hu.inno.sd.fabriek.mongo.example;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExampleRepository extends MongoRepository<Example, ObjectId> {
}
