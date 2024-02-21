package com.ufostyle.customerservice.services;

import com.ufostyle.customerservice.entities.Customer;
import com.ufostyle.customerservice.mappers.CustomerMapper;
import com.ufostyle.customerservice.noodle.Client;
import com.ufostyle.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Esto es la interfaz CustomerService.
 */
@Service
public class CustomerService {

  private static final String ESTADO_ACTIVO_CUSTOMER = "ACTIVO";
  private static final String ESTADO_INACTIVO_CUSTOMER = "INACTIVO";

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

  public Flux<Client> findAll() {
    return customerRepository.findAll()
        .flatMap(customer3 -> Mono.just(CustomerMapper.client(customer3)));
  }

  public Mono<Client> findById(String id) {
    return customerRepository.findById(id)
        .flatMap(customer4 -> Mono.just(CustomerMapper.client(customer4)));
  }

  public Mono<Void> deleteById(String id) {
    return customerRepository.deleteById(id);
  }

  public Mono<Client> findByNumberDocumentIdentity(String numberDocumentIdentity) {
    return  customerRepository.findByNumberDocumentIdentity(numberDocumentIdentity)
        .switchIfEmpty(Mono.empty())
        .filter(numDocId -> numDocId.getStatus().equalsIgnoreCase("ACTIVO"));
  }
}
