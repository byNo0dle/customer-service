package com.ufostyle.customerservice.entities;

import lombok.Builder;
import lombok.Data;

/**
 * Esto es la clase TypeDocumentIdentity.
 */
@Builder
@Data
public class TypeDocumentIdentity {

  private String code;
  private String description;
  private boolean isActive;
}
