package com.ufostyle.customerservice.services;

import com.ufostyle.customerservice.entities.Customer;
import com.ufostyle.customerservice.mappers.CustomerMapper;
import com.ufostyle.customerservice.noodle.Client;
import com.ufostyle.customerservice.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Esto es la clase CustomerService.
 */
@Slf4j
@Service
public class CustomerService {

  private static final String ESTADO_ACTIVO_CUSTOMER = "ACTIVO";
  private static final String ESTADO_INACTIVO_CUSTOMER = "INACTIVO";

  @Autowired
  CustomerRepository customerRepository;

  /**
   * Esto es el metodo saveClient.
   *
   * @param client esto es un parametro de openapi
   * @return customer
   */
  public Mono<Client> save(Client client) {
    log.info("--- Se creo un nuevo cliente: ---");
    return customerRepository.save(CustomerMapper.customer(client))
        .flatMap(customer1 -> Mono.just(CustomerMapper.client(customer1)));
  }

  /**
   * Esto es el metodo updateClient.
   *
   * @param client esto es un parametro de openapi
   * @return customer
   */
  public Mono<Client> update(Client client) {
    log.info("--- Se acutalizo la información del cliente: ---");
    return customerRepository.save(CustomerMapper.customer(client))
        .flatMap(customer2 -> Mono.just(CustomerMapper.client(customer2)));
  }

  /**
   * Esto es el metodo findAllClient.
   *
   * @return customer
   */
  public Flux<Client> findAll() {
    log.info("--- Obteniendo a todos los clientes: ---");
    return customerRepository.findAll()
        .flatMap(customer3 -> Mono.just(CustomerMapper.client(customer3)));
  }

  /**
   * Esto es el metodo findByIdClient.
   *
   * @param id esto es un parametro de openapi
   * @return customer
   */
  public Mono<Client> findById(String id) {
    log.info("--- Obteniendo un cliente por su id: ---");
    return customerRepository.findById(id)
        .flatMap(customer4 -> Mono.just(CustomerMapper.client(customer4)));
  }

  /**
   * Esto es el metodo deleteByIdClient.
   *
   * @param id esto es el parametro de openapi
   * @return customer
   */
  public Mono<Void> deleteById(String id) {
    log.info("--- Eliminar a un cliente por su id: ---");
    return customerRepository.deleteById(id);
  }

  /**
   * Esto llama a la clase Client de openapi.
   *
   * @param numberDocumentIdentity esto es el parametro de trae de la clase Customer
   * @return customer
   */
  public Mono<Client> findByNumberDocumentIdentity(String numberDocumentIdentity) {
    log.info("--- Obteniendo a un cliente por su numero de documento: ---");
    return customerRepository.findByNumberDocumentIdentity(numberDocumentIdentity)
        .switchIfEmpty(Mono.empty())
        .filter(numDocId -> numDocId.getStatus().equalsIgnoreCase("ACTIVO"));
  }
}
