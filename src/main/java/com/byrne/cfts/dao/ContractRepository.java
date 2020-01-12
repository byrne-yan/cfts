package com.byrne.cfts.dao;

import com.byrne.cfts.domain.Contract;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends ReactiveMongoRepository<Contract, String> {
}
