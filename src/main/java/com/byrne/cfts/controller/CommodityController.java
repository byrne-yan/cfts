package com.byrne.cfts.controller;

import com.byrne.cfts.domain.Commodity;
import com.byrne.cfts.domain.Exchange;
import com.byrne.cfts.handler.CommodityHandler;
import com.byrne.cfts.handler.ExchangeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value ="/api/commodity")
public class CommodityController {
    @Autowired
    private CommodityHandler commodityHandler;
    @GetMapping(value = "/{id}")
    public Mono<Commodity> findCityById(@PathVariable("id") String id) {
        return commodityHandler.findCommodityById(id);

    }
    @GetMapping()
    public Flux<Commodity> findAllCommodity() {
        return commodityHandler.findAllCommodity();
    }
    @PostMapping()
    public Mono<Commodity> saveCity(@RequestBody Commodity commodity) {
        return commodityHandler.save(commodity);
    }
    @PutMapping()
    public Mono<Commodity> modifyCity(@RequestBody Commodity commodity) {
        return commodityHandler.modifyCommodity(commodity);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<String> deleteCity(@PathVariable("id") String id) {
        return commodityHandler.deleteCommodity(id);
    }
}
