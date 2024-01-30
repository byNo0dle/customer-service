package com.ufostyle.customerservice.mappers;

import com.ufostyle.customerservice.entities.Client;
import com.ufostyle.customerservice.noodle.Customer;

/**
 * Esto es la clase ClientMapper.
 */
public class ClientMapper {

  /**
   * Esto es la clase static Client.
   *
   * @param customer esto es un parametro
   * @return esto retorna el Customer
   */
  public static Client clientEntity(Customer customer) {
    return Client.builder()
        .id(customer.getId())
        .firstName(customer.getFirstName())
        .lastName(customer.getLastName())
        .emailAddress(customer.getEmailAddress())
        .phoneNumber(customer.getPhoneNumber())
        .homeAddress(customer.getHomeAddress())
        .tdDocument(TypeDocumentMapper.tdDocument(customer.getDocumentType()))
        .tcClient(TypeClientMapper.tcClient(customer.getClientType()))
        .build();
  }

  /**
   * Esto es la clase static Customer.
   *
   * @param client esto es un parametro
   * @return retorna el Client
   */
  public static Customer customer(Client client) {
    Customer customer = new Customer();
    customer.setId(client.getId());
    customer.setFirstName(client.getFirstName());
    customer.setLastName(client.getLastName());
    customer.setEmailAddress(client.getEmailAddress());
    customer.setPhoneNumber(client.getPhoneNumber());
    customer.setHomeAddress(client.getHomeAddress());
    customer.setClientType(TypeClientMapper.clientType(client.getTcClient()));
    customer.setDocumentType(TypeDocumentMapper.documentType(client.getTdDocument()));
    return customer;
  }
}
