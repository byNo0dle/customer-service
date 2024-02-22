package com.ufostyle.customerservice.mappers;

import com.ufostyle.customerservice.entities.TypeDocumentIdentity;
import com.ufostyle.customerservice.noodle.IdentityDocumentType;

/**
 * Esto es la clase TypeDocumentIdentityMapper.
 */
public class TypeDocumentIdentityMapper {

  /**
   * Esto es la clase static TypeDocumentIdentity.
   *
   * @param identityDocumentType esto es un parametro de openapi
   * @return typeDocumentIdentity
   */
  public static TypeDocumentIdentity typeDocumentIdentity(
      IdentityDocumentType identityDocumentType) {
    return TypeDocumentIdentity.builder()
        .code(identityDocumentType.getCode())
        .description(identityDocumentType.getDescription())
        .isActive(identityDocumentType.getIsActive())
        .build();
  }

  /**
   * Esto es la clase static IdentityDocumentType.
   *
   * @param typeDocumentIdentity esto es un parametro de identityDocumentType
   * @return identityDocumentType
   */
  public static IdentityDocumentType identityDocumentType(
      TypeDocumentIdentity typeDocumentIdentity) {
    IdentityDocumentType identityDocumentType = new IdentityDocumentType();
    identityDocumentType.setCode(typeDocumentIdentity.getCode());
    identityDocumentType.setDescription(typeDocumentIdentity.getDescription());
    identityDocumentType.setIsActive(typeDocumentIdentity.isActive());
    return identityDocumentType;
  }
}
