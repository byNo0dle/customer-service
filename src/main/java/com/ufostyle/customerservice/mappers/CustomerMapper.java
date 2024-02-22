package com.ufostyle.customerservice.mappers;

import com.ufostyle.customerservice.entities.Customer;
import com.ufostyle.customerservice.noodle.Client;

/**
 * Esto es la clase CustomerMapper.
 */
public class CustomerMapper {

  /**
   * Esto es la clase static Customer.
   *
   * @param client esto es un parametro de openapi
   * @return customer
   */
  public static Customer customer(Client client) {
    return Customer.builder()
        .id(client.getId())
        .firstName(client.getFirstName())
        .lastName(client.getLastName())
        .emailAddress(client.getEmailAddress())
        .phoneNumber(client.getPhoneNumber())
        .gender(client.getGender())
        .numberDocumentIdentity(client.getNumberDocumentIdentity())
        .status(client.getStatus())
        .isActive(client.getIsActive())
        .address(AddressMapper.address(client.getDirection()))
        .customerProfile(CustomerProfileMapper.customerProfile(client.getProfileCustomer()))
        .customerType(CustomerTypeMapper.customerType(client.getTypeCustomer()))
        .typeDocumentIdentity(TypeDocumentIdentityMapper.typeDocumentIdentity(
            client.getIdentityDocumentType()))
        .build();
  }

  /**
   * Esto es la clase static Client.
   *
   * @param customer esto es un parametro de customer
   * @return client
   */
  public static Client client(Customer customer) {
    Client client = new Client();
    client.setId(customer.getId());
    client.setFirstName(customer.getFirstName());
    client.setLastName(customer.getLastName());
    client.setEmailAddress(customer.getEmailAddress());
    client.setPhoneNumber(customer.getPhoneNumber());
    client.setGender(customer.getGender());
    client.setNumberDocumentIdentity(customer.getNumberDocumentIdentity());
    client.setStatus(customer.getStatus());
    client.setIsActive(customer.isActive());
    client.setDirection(AddressMapper.direction(customer.getAddress()));
    client.setProfileCustomer(CustomerProfileMapper.profileCustomer(customer.getCustomerProfile()));
    client.setTypeCustomer(CustomerTypeMapper.typeCustomer(customer.getCustomerType()));
    client.setIdentityDocumentType(TypeDocumentIdentityMapper.identityDocumentType(
        customer.getTypeDocumentIdentity()));
    return client;
  }
}
