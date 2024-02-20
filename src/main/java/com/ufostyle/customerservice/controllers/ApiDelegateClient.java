package com.ufostyle.customerservice.controllers;

//import com.ufostyle.customerservice.noodle.Customer;
import com.ufostyle.customerservice.services.ClientService;
//import com.ufostyle.customerservice.ufo.ClientApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Esto es el ApiDelegate esto reemplaza al Controller clasico.
 */
@Component
public class ApiDelegateClient {

  /*@Autowired
  private ClientService clientService;

  @Override
  public Mono<ResponseEntity<Customer>> saveClient(
      Mono<Customer> customer, ServerWebExchange exchange) {
    return customer
        .flatMap(requestCustomer1 -> clientService.save(requestCustomer1))
        .flatMap(createCustomer -> Mono.just(ResponseEntity.ok(createCustomer)));
  }

  @Override
  public Mono<ResponseEntity<Customer>> updateClient(
      Mono<Customer> customer, ServerWebExchange exchange) {
    return customer
        .flatMap(requestCustomer2 -> clientService.update(requestCustomer2))
        .flatMap(updateCustomer -> Mono.just(ResponseEntity.ok(updateCustomer)));
  }

  @Override
  public Mono<ResponseEntity<Flux<Customer>>> findAllClient(ServerWebExchange exchange) {
    return Mono.just(ResponseEntity.ok(clientService.findAll()));
  }

  @Override
  public Mono<ResponseEntity<Customer>> findByIdClient(String id, ServerWebExchange exchange) {
    return clientService.findById(id)
        .flatMap(findAllCustomer -> Mono.just(ResponseEntity.ok(findAllCustomer)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @Override
  public Mono<ResponseEntity<Void>> deleteClient(String id, ServerWebExchange exchange) {
    return clientService.deleteById(id)
        .then(Mono.just(ResponseEntity.noContent().<Void>build()))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }*/
}
