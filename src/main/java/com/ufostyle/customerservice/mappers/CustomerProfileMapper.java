package com.ufostyle.customerservice.mappers;

import com.ufostyle.customerservice.entities.CustomerProfile;
import com.ufostyle.customerservice.noodle.ProfileCustomer;

/**
 * Esto es la clase CustomerProfileMapper.
 */
public class CustomerProfileMapper {

  /**
   * Esto es la clase static CustomerProfile.
   *
   * @param profileCustomer esto es parametro de openapi
   * @return customer
   */
  public static CustomerProfile customerProfile(ProfileCustomer profileCustomer) {
    return CustomerProfile.builder()
        .code(profileCustomer.getCode())
        .description(profileCustomer.getDescription())
        .status(profileCustomer.getStatus())
        .build();
  }

  /**
   * Esto es la clase static ProfileCustomer.
   *
   * @param customerProfile esto es parametro de customerProfile
   * @return profileCustomer
   */
  public static ProfileCustomer profileCustomer(CustomerProfile customerProfile) {
    ProfileCustomer profileCustomer = new ProfileCustomer();
    profileCustomer.setCode(customerProfile.getCode());
    profileCustomer.setDescription(customerProfile.getDescription());
    profileCustomer.setStatus(customerProfile.isStatus());
    return profileCustomer;
  }
}
