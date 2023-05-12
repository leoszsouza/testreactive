package com.example.testreactive.database;

import com.example.testreactive.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Slf4j
public class InMemoryDatabase implements Database{

    private static List<String> DATABASE = new CopyOnWriteArrayList<>();
    @Override
    public Mono<Person> save(Person person) {
        return Mono.fromCallable(() -> {
            DATABASE.add(person.getName());
            return person;
        }).subscribeOn(Schedulers.parallel());
    }

    @Override
    public Mono<List<String>> list() {
        return Mono.fromCallable(() -> DATABASE).subscribeOn(Schedulers.parallel());
    }

    @Override
    public Mono<String> get(String name) {
        return Mono.fromCallable(() ->
                DATABASE.stream()
                .filter(s -> s.equalsIgnoreCase(name))
                .findFirst().orElse(null));
    }
}
