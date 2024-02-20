package com.ufostyle.customerservice.repositories;

import com.ufostyle.customerservice.entities.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Esto es la interfaz CustomerRepository.
 */
public interface ClientRepository extends ReactiveMongoRepository<Customer, String> {
}
