package com.example.testreactive.controller;

import com.example.testreactive.database.Database;
import com.example.testreactive.model.Person;
import com.example.testreactive.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("testnames")
@RequiredArgsConstructor
public class ReactiveController {

    public final Database database;
    public final PersonRepository personRepository;
    @GetMapping
    public Mono<List<String>> listNames(){
        return database.list();
    }
    @PostMapping
    public Mono<Person> save(@RequestBody final Person person) {
        return database.save(person);
    }

    @GetMapping("/{name}")
    public Mono<String> getByName(@PathVariable String name) {
        return database.get(name);
    }

    @PostMapping("/save-default")
    public Person saveDefault(@RequestBody final Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/list-default")
    public Iterable<Person> listNamesDefault(){
        return personRepository.findAll();
    }
    @GetMapping("/find-default/{name}")
    public Person getDefaultByName(@PathVariable String name) {
        return personRepository.findOneByName(name);
    }

    @DeleteMapping("/delete-default/{name}")
    public void deleteDefaultByName(@PathVariable String name) {
        Person person = personRepository.findOneByName(name);
        personRepository.delete(person);
    }
}
