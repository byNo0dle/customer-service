package com.ufostyle.customerservice.entities;

import lombok.Builder;
import lombok.Data;

/**
 * Esto es la clase Address.
 */
@Builder
@Data
public class Address {

  private String type;
  private String name;
  private String number;
  private String province;
  private String district;
  private String department;
}
