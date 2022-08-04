package com.example.customerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable //Using this since this is not a different table.
public class Address {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Long id;
    private String street;
    private String city;
    private int zipcode;
    private String country;

}
