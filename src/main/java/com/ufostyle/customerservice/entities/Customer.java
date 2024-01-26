package com.ufostyle.customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Esto es la clase Customer.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "customers")
public class Customer {

  @Id
  private String id;
  private String firstName;
  private String lastName;
  private String documentNumber;
  private String emailAddress;
  private String phoneNumber;
  private String homeAddress;
  private TypeDocument typeDocument;
  private TypeCustomer typeCustomer;
}
