package com.service.order;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FeeRepository extends ReactiveMongoRepository<Fee, String> {
}
