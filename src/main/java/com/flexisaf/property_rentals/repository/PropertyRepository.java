package com.flexisaf.property_rentals.repository;

import com.flexisaf.property_rentals.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property,Long> {
    List<Property> findByLocality(String locality);
}