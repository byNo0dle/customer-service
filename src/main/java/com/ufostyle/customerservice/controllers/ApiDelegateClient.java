package com.ufostyle.customerservice.controllers;

import com.ufostyle.customerservice.noodle.Client;
import com.ufostyle.customerservice.services.CustomerService;
import com.ufostyle.customerservice.ufo.ClientApiDelegate;
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
public class ApiDelegateClient implements ClientApiDelegate {

  @Autowired
  private CustomerService customerService;

  @Override
  public Mono<ResponseEntity<Client>> saveClient(Mono<Client> client, ServerWebExchange exchange) {
    return client
        .flatMap(requestClient1 -> customerService.save(requestClient1))
        .flatMap(createClient -> Mono.just(ResponseEntity.ok(createClient)));
  }

  @Override
  public Mono<ResponseEntity<Client>> updateClient(Mono<Client> client, ServerWebExchange exchange) {
    return client
        .flatMap(requestClient2 -> customerService.update(requestClient2))
        .flatMap(updateClient -> Mono.just(ResponseEntity.ok(updateClient)));
  }

  @Override
  public Mono<ResponseEntity<Flux<Client>>> findAllClient(ServerWebExchange exchange) {
    return Mono.just(ResponseEntity.ok(customerService.findAll()));
  }

  @Override
  public Mono<ResponseEntity<Client>> findByIdClient(String id, ServerWebExchange exchange) {
    return customerService.findById(id)
        .flatMap(findAllClient -> Mono.just(ResponseEntity.ok(findAllClient)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @Override
  public Mono<ResponseEntity<Void>> deleteClient(String id, ServerWebExchange exchange) {
    return customerService.deleteById(id)
        .then(Mono.just(ResponseEntity.noContent().<Void>build()))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @Override
  public Mono<ResponseEntity<Client>> findByNumberDocumentIdentityClient(String numberDocumentIdentity, ServerWebExchange exchange) {
    return customerService.findByNumberDocumentIdentity(numberDocumentIdentity)
        .flatMap(numDocId -> Mono.just(ResponseEntity.ok().body(numDocId)))
        .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build()));
  }
}
