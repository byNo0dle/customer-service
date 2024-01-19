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

@Service
public class CustomerServiceImpl implements CustomerService{

    CustomerRepository customerRepository;
    RestTemplate restTemplate;

    @Value("${api.tableId-service.uri}")
    String tableIdService;

    @Override
    public Long generateKey(String nameTable) {
        //log.info(tableIdService + "/generateKey/" + nameTable);
        ResponseEntity<Long> responseGet = restTemplate.exchange(tableIdService + "/generateKey/" + nameTable, HttpMethod.GET,
                null, new ParameterizedTypeReference<Long>() {
                });
        if (responseGet.getStatusCode() == HttpStatus.OK) {
            //log.info("Body:"+ responseGet.getBody());
            return responseGet.getBody();
        } else {
            return Long.valueOf(0);
        }
    }

    @Override
    public Flux<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        Long key=generateKey(Customer.class.getSimpleName());
        if(key>=1) {
            customer.setId(key);
            //log.info("SAVE[product]:"+customer.toString());
        }
        return customerRepository.save(customer);
    }

    @Override
    public Mono<Customer> update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Mono<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return customerRepository.deleteById(id);
    }
}
