package com.ufostyle.customerservice.entities;

import lombok.Data;

@Data
public class TypeDocumentIdentity {

  private String code;
  private String description;
  private boolean isActive;
}
