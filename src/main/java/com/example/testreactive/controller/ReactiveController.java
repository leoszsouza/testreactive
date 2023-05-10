package com.example.testreactive.controller;

import com.example.testreactive.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("testnames")
@RequiredArgsConstructor
public class ReactiveController {

    public final Database database;
    @GetMapping
    public Mono<List<String>> listNames(){
        return database.list();
    }

    @PostMapping
    public Mono<RequestInput> save(@RequestBody final RequestInput requestInput) {
        return database.save(requestInput);
    }

    @GetMapping("/{name}")
    public Mono<String> getByName(@PathVariable String name) {
        return database.get(name);
    }

}
