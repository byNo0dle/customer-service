package com.ufostyle.customerservice.mappers;

import com.ufostyle.customerservice.entities.TypeDocument;
import com.ufostyle.customerservice.noodle.DocumentType;

/**
 * Esto es la clase TypeDocumentMapper.
 */
public class TypeDocumentMapper {

  /**
   * Esto es la clase static TypeDocument.
   *
   * @param documentType esto es un parametro
   * @return esto retorna TypeDocument
   */
  public static TypeDocument tdDocument(DocumentType documentType) {
    return TypeDocument.builder()
        .document(documentType.getDocument())
        .documentNumber(documentType.getDocumentNumber())
        .build();
  }

  /**
   * Esto es la clase static DocumentType.
   *
   * @param tdDocument esto es un parametro
   * @return esto retorna documentType
   */
  public static DocumentType documentType(TypeDocument tdDocument) {
    DocumentType documentType = new DocumentType();
    documentType.setDocument(tdDocument.getDocument());
    documentType.documentNumber(tdDocument.getDocumentNumber());
    return documentType;
  }
}
