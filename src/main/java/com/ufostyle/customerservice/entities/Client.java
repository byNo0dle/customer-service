package com.ufostyle.customerservice.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Esto es la clase Client.
 */
@Builder
@Data
@Document(collection = "customers")
public class Client {

  @Id
  private String id;
  private String firstName;
  private String lastName;
  private String emailAddress;
  private String phoneNumber;
  private String homeAddress;
  private TypeDocument tdDocument;
  private TypeClient tcClient;
}
