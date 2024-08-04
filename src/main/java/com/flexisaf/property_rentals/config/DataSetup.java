package com.flexisaf.property_rentals.config;

import com.flexisaf.property_rentals.entity.Role;
import com.flexisaf.property_rentals.entity.User;
import com.flexisaf.property_rentals.repository.RoleRepository;
import com.flexisaf.property_rentals.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class DataSetup {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            adminRole = roleRepository.save(adminRole);

            Role ownerRole = new Role();
            ownerRole.setName("ROLE_OWNER");
            roleRepository.save(ownerRole);

            Role customerRole = new Role();
            customerRole.setName("ROLE_CUSTOMER");
            roleRepository.save(customerRole);

            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(new BCryptPasswordEncoder().encode("password"));
            admin.setRoles(adminRoles);
            userRepository.save(admin);

            Set<Role> ownerRoles = new HashSet<>();
            ownerRoles.add(ownerRole);
            User owner = new User();
            owner.setUsername("owner");
            owner.setPassword(new BCryptPasswordEncoder().encode("password"));
            owner.setRoles(ownerRoles);
            userRepository.save(owner);

            Set<Role> customerRoles = new HashSet<>();
            customerRoles.add(customerRole);
            User customer = new User();
            customer.setUsername("customer");
            customer.setPassword(new BCryptPasswordEncoder().encode("password"));
            customer.setRoles(customerRoles);
            userRepository.save(customer);
        };
    }
    
}
