package com.ufostyle.customerservice.mappers;

import com.ufostyle.customerservice.entities.TypeDocumentIdentity;
import com.ufostyle.customerservice.noodle.IdentityDocumentType;

public class TypeDocumentIdentityMapper {

  public static TypeDocumentIdentity typeDocumentIdentity(IdentityDocumentType identityDocumentType) {
    return TypeDocumentIdentity.builder()
        .code(identityDocumentType.getCode())
        .description(identityDocumentType.getDescription())
        .isActive(identityDocumentType.getIsActive())
        .build();
  }

  public static IdentityDocumentType identityDocumentType(TypeDocumentIdentity typeDocumentIdentity) {
    IdentityDocumentType identityDocumentType = new IdentityDocumentType();
    identityDocumentType.setCode(typeDocumentIdentity.getCode());
    identityDocumentType.setDescription(typeDocumentIdentity.getDescription());
    identityDocumentType.setIsActive(typeDocumentIdentity.isActive());
    return  identityDocumentType;
  }
}
