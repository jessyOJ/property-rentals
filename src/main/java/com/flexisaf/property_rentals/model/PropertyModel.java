package com.flexisaf.property_rentals.model;

import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class PropertyModel {
    private Long id;
    private String locality;
    private int numberOfRooms;
    private String address;
    private double rent;
    private OwnerModel owner;
}
