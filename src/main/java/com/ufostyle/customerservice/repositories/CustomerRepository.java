package com.ufostyle.customerservice.repositories;

import com.ufostyle.customerservice.entities.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Esto es la interfaz CustomerRepository.
 */
@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
}
