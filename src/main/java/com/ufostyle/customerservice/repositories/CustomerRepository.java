package com.ufostyle.customerservice.repositories;

import com.ufostyle.customerservice.entities.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, Long> {
}
