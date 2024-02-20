package com.ufostyle.customerservice.entities;


import lombok.Builder;
import lombok.Data;

/**
 * Esto es la clase TypeClient.
 */
@Builder
@Data
public class CustomerProfile {

  private String code;
  private String description;
  private boolean status;
}
