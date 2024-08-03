package com.flexisaf.property_rentals.service;

import com.flexisaf.property_rentals.entity.User;

import com.flexisaf.property_rentals.entity.Property;
import com.flexisaf.property_rentals.exceptions.ResourceNotFoundException;
import com.flexisaf.property_rentals.repository.UserRepository;
import com.flexisaf.property_rentals.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyService {
   @Autowired
   private PropertyRepository propertyRepository;
    @Autowired
   private UserRepository userRepository;

   public List<Property>getAllProperties(){
       return propertyRepository.findAll();
   }
   public Property addProperty(Property property,String name){
       User user = userRepository.findByUsername(name)
               .orElseThrow(()-> new ResourceNotFoundException("Cannot find User"));
       property.setOwner(user);
       return propertyRepository.save(property);
   }
   public List<Property>getByLocality(String locality){

       return propertyRepository.findByLocality(locality);
   }
}
