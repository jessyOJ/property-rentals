package com.flexisaf.property_rentals.repository;

import com.flexisaf.property_rentals.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role>findByName(String name);
}
