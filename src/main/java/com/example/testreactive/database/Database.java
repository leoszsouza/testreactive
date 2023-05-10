package com.example.testreactive.database;

import com.example.testreactive.controller.RequestInput;
import reactor.core.publisher.Mono;

import java.util.List;

public interface Database {
    Mono<RequestInput> save (RequestInput requestInput);
    Mono<List<String>> list();
    Mono<String> get(String name);
}
