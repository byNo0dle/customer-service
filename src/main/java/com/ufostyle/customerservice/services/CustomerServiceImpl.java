package com.ufostyle.customerservice.services;

import com.ufostyle.customerservice.entities.Customer;
import com.ufostyle.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Esto es la clase CustomerServiceImpl.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  RestTemplate restTemplate;

  @Override
  public Flux<Customer> findAll() {
    return customerRepository.findAll();
  }

  @Override
  public Mono<Customer> save(Customer customer) {
    return customerRepository.save(customer);
  }

  @Override
  public Mono<Customer> update(Customer customer) {
    return customerRepository.save(customer);
  }

  @Override
  public Mono<Customer> findById(String id) {
    return customerRepository.findById(id);
  }

  @Override
  public Mono<Void> delete(String id) {
    return customerRepository.deleteById(id);
  }
}
