package com.ufostyle.customerservice.mappers;

import com.ufostyle.customerservice.entities.CustomerType;
import com.ufostyle.customerservice.noodle.TypeCustomer;

/**
 * Esto es la clase TypeDocumentMapper.
 */
public class CustomerTypeMapper {

  public static CustomerType customerType(TypeCustomer typeCustomer) {
    return CustomerType.builder()
        .code(typeCustomer.getCode())
        .description(typeCustomer.getDescription())
        .isActive(typeCustomer.getIsActive())
        .build();
  }

  public static TypeCustomer typeCustomer(CustomerType customerType) {
    TypeCustomer typeCustomer = new TypeCustomer();
    typeCustomer.setCode(customerType.getCode());
    typeCustomer.setDescription(customerType.getDescription());
    typeCustomer.setIsActive(customerType.isActive());
    return typeCustomer;
  }
}
