package com.byrne.cfts.handler;

import com.byrne.cfts.dao.CommodityRepository;
import com.byrne.cfts.dao.ContractRepository;
import com.byrne.cfts.domain.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Component
public class ContractHandler {
    private final ContractRepository contractRepository;
    private final CommodityRepository commodityRepository;

    @Autowired
    public ContractHandler(ContractRepository contractRepository, CommodityRepository commodityRepository){
        this.contractRepository = contractRepository;
        this.commodityRepository = commodityRepository;
    }

    public Mono<Contract> save(Contract contract) {
        Mono a = Mono.from(commodityRepository.findById(contract.getProductCode())
                .flatMap(cc->contractRepository.save(contract)));
        return  a;

    }

    public Mono<Contract> findContractById(String id){
        return contractRepository.findById(id);
    }

    public Flux<Contract> findAllContract() {
        return contractRepository.findAll();
    }

    public Mono<Contract> modifyContract(Contract contract) {
        return contractRepository.save(contract);
    }

    public Mono<String> deleteContract(String code) {
        contractRepository.deleteById(code);
        return Mono.create(exchangeMonoSink -> exchangeMonoSink.success(code));
    }
}
