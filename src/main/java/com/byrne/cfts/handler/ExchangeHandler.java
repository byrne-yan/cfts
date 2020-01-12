package com.byrne.cfts.handler;

import com.byrne.cfts.dao.ExchangeRepository;
import com.byrne.cfts.domain.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Component
public class ExchangeHandler {
    private final ExchangeRepository exchangeRepository;

    @Autowired
    public ExchangeHandler(ExchangeRepository exchangeRepository){
        this.exchangeRepository = exchangeRepository;
    }

    public Mono<Exchange> save(Exchange exchange) {
        return exchangeRepository.save(exchange);
    }

    public Mono<Exchange> findExchangeById(String id){
        return exchangeRepository.findById(id);
    }

    public Flux<Exchange> findAllExchange() {
        return exchangeRepository.findAll();
    }

    public Mono<Exchange> modifyExchange(Exchange exchange) {
        return exchangeRepository.save(exchange);
    }

    public Mono<String> deleteExchange(String code) {
        exchangeRepository.deleteById(code)
        ;
        return Mono.create(exchangeMonoSink -> exchangeMonoSink.success(code));
    }
}
