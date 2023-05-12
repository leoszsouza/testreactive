package com.example.testreactive.repository;

import com.example.testreactive.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person, String> {

    Person findOneByName(String name);
    Person deleteAllByName(String name);

}
