package com.flexisaf.property_rentals.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String username;
     private String password;

     @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
     @JoinTable(name = "Owner_properties",
             joinColumns =@JoinColumn(name = "owner_id"),
             inverseJoinColumns = @JoinColumn(name = "property_id")
     )
     private Set<Role> Roles;
}
