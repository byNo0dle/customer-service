package com.ufostyle.customerservice.services;

import com.ufostyle.customerservice.entities.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> findAll();
    Mono<Customer> save(Customer customer);
    Mono<Customer> update(Customer customer);
    Mono<Customer> findById(String id);
    Mono<Void> delete(String id);
}
