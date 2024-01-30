package com.ufostyle.customerservice.mappers;

import com.ufostyle.customerservice.entities.TypeClient;
import com.ufostyle.customerservice.noodle.ClientType;

/**
 * Esto es la clase TypeClientMapper.
 */
public class TypeClientMapper {
  /**
   * Esto es la clase static TypeClient.
   *
   * @param clientType esto es un parametro
   * @return retorna TypeClient
   */
  public static TypeClient tcClient(ClientType clientType) {
    return TypeClient.builder()
        .typeClient(clientType.getTypeClient())
        .status(clientType.getStatus())
        .build();
  }

  /**
   * Esto es la clase static ClientType.
   *
   * @param tcClient esto es un parametro
   * @return retorna clientType
   */
  public static ClientType clientType(TypeClient tcClient) {
    ClientType clientType = new ClientType();
    clientType.setTypeClient(tcClient.getTypeClient());
    clientType.setStatus(tcClient.getStatus());
    return clientType;
  }
}
