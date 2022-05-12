package com.example.securityclientrest.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    private AddressType addressType;
    private String street;
    private String city;
    private String state;
    private String zip;
}