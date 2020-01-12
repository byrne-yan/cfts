package com.byrne.cfts.handler;

import com.byrne.cfts.dao.CommodityRepository;
import com.byrne.cfts.dao.ExchangeRepository;
import com.byrne.cfts.domain.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Component
public class CommodityHandler {
    private final CommodityRepository commodityRepository;
    private final ExchangeRepository exchangeRepository;

    @Autowired
    public CommodityHandler(CommodityRepository commodityRepository, ExchangeRepository exchangeRepository){
        this.commodityRepository = commodityRepository;
        this.exchangeRepository = exchangeRepository;
    }

    public Mono<Commodity> save(Commodity commodity) {
        Mono a = Mono.from(
                exchangeRepository.findById(commodity.getExchangeCode())
                    .map(e->commodityRepository.save((commodity)))
        );

        return  a;
    }

    public Mono<Commodity> findCommodityById(String id){
        return commodityRepository.findById(id);
    }

    public Flux<Commodity> findAllCommodity() {
        return commodityRepository.findAll();
    }

    public Mono<Commodity> modifyCommodity(Commodity commodity) {
        return commodityRepository.save(commodity);
    }

    public Mono<String> deleteCommodity(String code) {
        commodityRepository.deleteById(code);
        return Mono.create(exchangeMonoSink -> exchangeMonoSink.success(code));
    }
}