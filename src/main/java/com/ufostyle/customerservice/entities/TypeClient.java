package com.ufostyle.customerservice.entities;


import lombok.Builder;
import lombok.Data;

/**
 * Esto es la clase TypeClient.
 */
@Builder
@Data
public class TypeClient {

  private String typeClient;
  private String status;
}
