package com.ufostyle.customerservice.entities;

import lombok.Builder;
import lombok.Data;

/**
 * Esto es la clase TypeDocument.
 */
@Builder
@Data
public class CustomerType {

  private String code;
  private String description;
  private boolean isActive;
}
