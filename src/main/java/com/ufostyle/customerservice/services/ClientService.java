package com.ufostyle.customerservice.services;

import com.ufostyle.customerservice.mappers.ClientMapper;
import com.ufostyle.customerservice.noodle.Customer;
import com.ufostyle.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Esto es la interfaz CustomerService.
 */
@Service
public class ClientService {

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  RestTemplate restTemplate;

  public Mono<Customer> save(Customer customer) {
    return customerRepository.save(ClientMapper.clientEntity(customer))
        .flatMap(client1 -> Mono.just(ClientMapper.customer(client1)));
  }

  public Mono<Customer> update(Customer customer) {
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
  }
}
