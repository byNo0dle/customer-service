package com.ufostyle.customerservice.mappers;

import com.ufostyle.customerservice.entities.CustomerProfile;
import com.ufostyle.customerservice.noodle.ProfileCustomer;

/**
 * Esto es la clase TypeClientMapper.
 */
public class CustomerProfileMapper {

  public static CustomerProfile customerProfile(ProfileCustomer profileCustomer) {
    return CustomerProfile.builder()
        .code(profileCustomer.getCode())
        .description(profileCustomer.getDescription())
        .status(profileCustomer.getStatus())
        .build();
  }

  public static ProfileCustomer profileCustomer(CustomerProfile customerProfile) {
    ProfileCustomer profileCustomer = new ProfileCustomer();
    profileCustomer.setCode(customerProfile.getCode());
    profileCustomer.setDescription(customerProfile.getDescription());
    profileCustomer.setStatus(customerProfile.isStatus());
    return profileCustomer;
  }
}
