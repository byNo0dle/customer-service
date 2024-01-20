package com.ufostyle.customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="customers")
public class Customer {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String documentNumber;
    private String emailAddress;
    private String phoneNumber;
    private String homeAddress;
    private TypeDocument typeDocument;
    private TypeCustomer typeCustomer;
}
