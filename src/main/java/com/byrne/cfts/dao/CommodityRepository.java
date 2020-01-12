package com.byrne.cfts.dao;

import com.byrne.cfts.domain.Commodity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityRepository extends ReactiveMongoRepository<Commodity, String> {
}
