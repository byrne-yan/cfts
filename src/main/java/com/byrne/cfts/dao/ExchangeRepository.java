package com.byrne.cfts.dao;

import com.byrne.cfts.domain.Contract;
import com.byrne.cfts.domain.Exchange;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ExchangeRepository extends ReactiveMongoRepository<Exchange, String> {
}
