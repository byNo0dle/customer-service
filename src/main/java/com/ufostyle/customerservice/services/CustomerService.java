package com.ufostyle.customerservice.services;

import com.ufostyle.customerservice.mappers.CustomerMapper;
import com.ufostyle.customerservice.noodle.Client;
import com.ufostyle.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Esto es la interfaz CustomerService.
 */
@Service
public class CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  public Mono<Client> save(Client client) {
    return customerRepository.save(CustomerMapper.customer(client))
        .flatMap(customer1 -> Mono.just(CustomerMapper.client(customer1)));
  }

  public Mono<Client> update(Client client) {
    return customerRepository.save(CustomerMapper.customer(client))
        .flatMap(customer2 -> Mono.just(CustomerMapper.client(customer2)));
  }

  /*public Mono<Customer> update(Customer customer) {
    return customerRepository.save(ClientMapper.clientEntity(customer))
        .flatMap(client2 -> Mono.just(ClientMapper.customer(client2)));
  }


  public Flux<Customer> findAll() {
    return customerRepository.findAll()
        .flatMap(client3 -> Mono.just(ClientMapper.customer(client3)));
  }

  public Mono<Customer> findById(String id) {
    return customerRepository.findById(id)
        .flatMap(client4 -> Mono.just(ClientMapper.customer(client4)));
  }

  public Mono<Void> deleteById(String id) {
    return customerRepository.deleteById(id);
  }*/
}
