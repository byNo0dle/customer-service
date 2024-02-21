package com.ufostyle.customerservice.repositories;

import com.ufostyle.customerservice.entities.Customer;
import com.ufostyle.customerservice.noodle.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Esto es la interfaz CustomerRepository.
 */
@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

  Mono<Client> findByNumberDocumentIdentity(String numberDocumentIdentity);
}
