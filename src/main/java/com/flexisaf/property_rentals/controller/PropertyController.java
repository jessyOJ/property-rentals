package com.flexisaf.property_rentals.controller;

import com.flexisaf.property_rentals.entity.Property;
import com.flexisaf.property_rentals.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/property")
public class PropertyController {
    @Autowired
    public PropertyService propertyService;
    @PostMapping
    public ResponseEntity<Property> addProperty(@RequestBody Property property,@RequestParam String username){
        Property propertyData = propertyService.addProperty(property,username);
        return  ResponseEntity.ok(propertyData);
    }
    @GetMapping
    public ResponseEntity<List<Property>>getAllProperties(){
    return ResponseEntity.ok(propertyService.getAllProperties());
    }
    @GetMapping("/search")
    public  ResponseEntity<List<Property>>getPropertiesByLocality(@RequestParam String locality){
       return ResponseEntity.ok(propertyService.getByLocality(locality));
    }
}
