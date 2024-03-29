package com.ufostyle.customerservice.entities;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Esto es la clase Customer.
 */
@Builder
@Data
@Slf4j
@Document(collection = "customers")
public class Customer {

  @Id
  private String id = UUID.randomUUID().toString();
  private String firstName;
  private String lastName;
  private String emailAddress;
  private String phoneNumber;
  private String gender;
  private String numberDocumentIdentity;
  private String status;
  private boolean isActive;
  private Address address;
  private CustomerProfile customerProfile;
  private CustomerType customerType;
  private TypeDocumentIdentity typeDocumentIdentity;
}
