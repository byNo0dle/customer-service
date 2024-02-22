package com.ufostyle.customerservice.mappers;

import com.ufostyle.customerservice.entities.CustomerType;
import com.ufostyle.customerservice.noodle.TypeCustomer;

/**
 * Esto es la clase CustomerTypeMapper.
 */
public class CustomerTypeMapper {

  /**
   * Esto es la clase static CustomerType.
   *
   * @param typeCustomer esto es el parametro de open api
   * @return customerType
   */
  public static CustomerType customerType(TypeCustomer typeCustomer) {
    return CustomerType.builder()
        .code(typeCustomer.getCode())
        .description(typeCustomer.getDescription())
        .isActive(typeCustomer.getIsActive())
        .build();
  }

  /**
   * Esto es la clase static TypeCustomer.
   *
   * @param customerType esto es el parametro customerType
   * @return typeCustomer
   */
  public static TypeCustomer typeCustomer(CustomerType customerType) {
    TypeCustomer typeCustomer = new TypeCustomer();
    typeCustomer.setCode(customerType.getCode());
    typeCustomer.setDescription(customerType.getDescription());
    typeCustomer.setIsActive(customerType.isActive());
    return typeCustomer;
  }
}
