package com.flexisaf.property_rentals.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String locality;
    private int numberOfRooms;
    private String address;
    private double rent;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;


}
