package com.flexisaf.property_rentals.model;

import jakarta.persistence.Entity;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerModel {

    private Long id;
    private  String name;
    private String email;
    private String phoneNumber;

}
