package com.ufostyle.customerservice.controllers;

import com.ufostyle.customerservice.entities.Customer;
import com.ufostyle.customerservice.services.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Esto es la clase CustomerController.
 */
@Log4j2
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping
  public Flux<Customer> findAll() {
    return customerService.findAll();
  }

  /**
   * Esto es un GetMapping para Customer.
   *
   * @param id esto es el parametro para un customer
   * @return esto nos devuelve el customer en especifico
   */
  @GetMapping("/{id}")
  public Mono<ResponseEntity<Customer>> findById(@PathVariable("id") String id) {
    return customerService.findById(id).map(customers -> ResponseEntity.ok().body(customers))
        .onErrorResume(e -> {
          log.info("Error:" + e.getMessage());
          return Mono.just(ResponseEntity.badRequest().build());
        }).defaultIfEmpty(ResponseEntity.noContent().build());
  }

  /**
   * Esto es PostMapping de Customer.
   *
   * @param customer nos permite crear un nuevo customer
   * @return esto nos retorna un cuerpo de un customer.
   */
  @PostMapping
  public Mono<ResponseEntity<Customer>> saveCustomer(@RequestBody Customer customer) {
    return customerService.save(customer)
        .map(customers -> ResponseEntity.ok().body(customers)).onErrorResume(e -> {
          log.info("Error:" + e.getMessage());
          return Mono.just(ResponseEntity.badRequest().build());
        });
  }

  /**
   * Esto es el PutMapping de Customer.
   *
   * @param customer se pone los atributos de customer
   * @return nos devuelve el customer actualizado
   */
  @PutMapping
  public Mono<ResponseEntity<Customer>> updateCustomer(@RequestBody Customer customer) {
    Mono<Customer> objCustomer = customerService.findById(customer.getId()).flatMap(customers -> {
      log.info("Update: [new] " + customer + " [Old]: " + customers);
      return customerService.update(customer);
    });

    return objCustomer.map(custs -> {
      log.info("Status: " + HttpStatus.OK);
      return ResponseEntity.ok().body(custs);
    }).onErrorResume(e -> {
      log.info("Status: " + HttpStatus.BAD_REQUEST + " Message:  " + e.getMessage());
      return Mono.just(ResponseEntity.badRequest().build());
    }).defaultIfEmpty(ResponseEntity.noContent().build());
  }

  /**
   * Esto es el DeleteMapping de Customer.
   *
   * @param id se elimina el customer en especifico
   * @return nos permite poder eliminar
   */
  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> deleteCustomer(@PathVariable("id") String id) {
    return customerService.findById(id).flatMap(customer -> {
      return customerService.delete(customer.getId()).then(Mono.just(ResponseEntity.ok().build()));
    });
  }
}
