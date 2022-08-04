package com.example.customerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank (message = "Name may not be blank")
    @NotEmpty(message = "Name may not be empty")
    @NotNull(message = "Name may not be null")
    @Size(min = 2, message = "user name should have at least 2 characters")
    private String name;

    @NotEmpty(message = "Email may not be empty")
    @Email
    private String email;

    @NotEmpty(message = "phone may not be empty")
    @Size(min = 9, message = "phone should have at least 9 characters")
    private String phone;

    private int age;

    private String[] projects;

    //@OneToOne(cascade = CascadeType.ALL)
    //@MapsId
    @Embedded
    private Address address;

    @ElementCollection
    @JoinTable(
            name="customer_payment_methods",
            joinColumns = @JoinColumn( name="customer_id")
    )
    @Column(name="payment_methods")
    private List<String> paymentMethods;



    @ElementCollection
    @CollectionTable(name = "customer_profileInfo",
            joinColumns = {@JoinColumn(name = "customer_id")})
    @MapKeyColumn(name = "profile_name")
    @Column(name = "platform")
    private Map<String, String> profileInfo;
}
