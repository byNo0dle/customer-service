package com.ufostyle.customerservice.controllers;

import com.ufostyle.customerservice.entities.Customer;
import com.ufostyle.customerservice.services.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public Flux<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Customer>> findById(@PathVariable("id") Long id){
        return customerService.findById(id).map(_customer -> ResponseEntity.ok().body(_customer))
                .onErrorResume(e -> {
                    log.info("Error:" + e.getMessage());
                    return Mono.just(ResponseEntity.badRequest().build());
                }).defaultIfEmpty(ResponseEntity.noContent().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Customer>> saveCustomer(@RequestBody Customer customer){
        return customerService.save(customer).map(_customer -> ResponseEntity.ok().body(_customer)).onErrorResume(e -> {
            log.info("Error:" + e.getMessage());
            return Mono.just(ResponseEntity.badRequest().build());
        });
    }

    @PutMapping
    public Mono<ResponseEntity<Customer>> updateCustomer(@RequestBody Customer customer){
        Mono<Customer> objCustomer = customerService.findById(customer.getId()).flatMap(_customer -> {
            log.info("Update: [new] " + customer + " [Old]: " + _customer);
            return customerService.update(customer);
        });

        return objCustomer.map(_cust -> {
            log.info("Status: " + HttpStatus.OK);
            return ResponseEntity.ok().body(_cust);
        }).onErrorResume(e -> {
            log.info("Status: " + HttpStatus.BAD_REQUEST + " Message:  " + e.getMessage());
            return Mono.just(ResponseEntity.badRequest().build());
        }).defaultIfEmpty(ResponseEntity.noContent().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteCustomer(@PathVariable("id") Long id){
        return customerService.findById(id).flatMap(customer -> {
            return customerService.delete(customer.getId()).then(Mono.just(ResponseEntity.ok().build()));
        });
    }
}
