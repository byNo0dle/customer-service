package com.ufostyle.customerservice.mappers;

import com.ufostyle.customerservice.entities.Address;
import com.ufostyle.customerservice.noodle.Direction;

/**
 * Esto es la clase AddressMapper.
 */
public class AddressMapper {

  /**
   * Esto es la clase static Address.
   *
   * @param direction esto es un parametro del openapi
   * @return address
   */
  public static Address address(Direction direction) {
    return Address.builder()
        .type(direction.getType())
        .name(direction.getName())
        .number(direction.getNumber())
        .province(direction.getProvince())
        .district(direction.getDistrict())
        .department(direction.getDepartment())
        .build();
  }

  /**
   * Esto es la clase static Direction.
   *
   * @param address esto es parametro de address
   * @return direction
   */
  public static Direction direction(Address address) {
    Direction direction = new Direction();
    direction.setType(address.getType());
    direction.setName(address.getName());
    direction.setNumber(address.getNumber());
    direction.setProvince(address.getProvince());
    direction.setDistrict(address.getDistrict());
    direction.setDepartment(address.getDepartment());
    return direction;
  }
}
