package com.byrne.cfts.controller;

import com.byrne.cfts.domain.Commodity;
import com.byrne.cfts.domain.Contract;
import com.byrne.cfts.handler.CommodityHandler;
import com.byrne.cfts.handler.ContractHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value ="/api/contract")
public class ContractController {
    @Autowired
    private ContractHandler contractHandler;
    @GetMapping(value = "/{id}")
    public Mono<Contract> findCityById(@PathVariable("id") String id) {
        return contractHandler.findContractById(id);

    }
    @GetMapping()
    public Flux<Contract> findAllContract() {
        return contractHandler.findAllContract();
    }
    @PostMapping()
    public Mono<Contract> saveCity(@RequestBody Contract contract) {
        return contractHandler.save(contract);
    }
    @PutMapping()
    public Mono<Contract> modifyCity(@RequestBody Contract contract) {
        return contractHandler.modifyContract(contract);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<String> deleteCity(@PathVariable("id") String id) {
        return contractHandler.deleteContract(id);
    }
}