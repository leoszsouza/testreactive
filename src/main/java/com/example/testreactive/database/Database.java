package com.example.testreactive.database;

import com.example.testreactive.model.Person;
import reactor.core.publisher.Mono;

import java.util.List;

public interface Database {
    Mono<Person> save (Person person);
    Mono<List<String>> list();
    Mono<String> get(String name);
}
