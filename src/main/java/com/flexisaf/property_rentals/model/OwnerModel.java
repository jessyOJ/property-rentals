package com.flexisaf.property_rentals.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OwnerModel {

     private Long id;
     private String username;
     private String password;
     private Set<PropertyModel> properties;
}
