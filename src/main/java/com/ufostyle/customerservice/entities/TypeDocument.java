package com.ufostyle.customerservice.entities;

import lombok.Builder;
import lombok.Data;

/**
 * Esto es la clase TypeDocument.
 */
@Builder
@Data
public class TypeDocument {

  private String document;
  private String documentNumber;
}
