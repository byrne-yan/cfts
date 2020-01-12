package com.byrne.cfts.controller;

import com.byrne.cfts.domain.Exchange;
import com.byrne.cfts.handler.ExchangeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value ="/api/exchange")
public class ExchangeController {
    @Autowired
    private ExchangeHandler exchangeHandler;

    @GetMapping(value = "/{id}")
    public Mono<Exchange> findCityById(@PathVariable("id") String id) {
        return exchangeHandler.findExchangeById(id);

    }
    @GetMapping()
    public Flux<Exchange> findAllExchange() {
        return exchangeHandler.findAllExchange();
    }
    @PostMapping()
    public Mono<Exchange> saveExchange(@RequestBody Exchange exchange) {
        return exchangeHandler.save(exchange);
    }
    @PutMapping()
    public Mono<Exchange> modifyExchange(@RequestBody Exchange exchange) {
        return exchangeHandler.modifyExchange(exchange);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<String> deleteExchange(@PathVariable("id") String id) {
        return exchangeHandler.deleteExchange(id);
    }
}