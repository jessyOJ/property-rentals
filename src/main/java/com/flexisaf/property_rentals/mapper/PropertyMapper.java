package com.flexisaf.property_rentals.mapper;

import com.flexisaf.property_rentals.entity.Property;
import com.flexisaf.property_rentals.model.OwnerModel;
import com.flexisaf.property_rentals.model.PropertyModel;
import org.springframework.beans.factory.annotation.Autowired;


public class PropertyMapper {
    @Autowired
    OwnerModel ownerModel;
    public static Property mapToProperty(PropertyModel propertyModel){

        return new Property(

//                propertyModel.getId(),
//                propertyModel.getAddress(),
//                propertyModel.getNumberOfRooms(),
//                propertyModel.getLocality(),
//                propertyModel.getRent(),
//                propertyModel.getOwner()
        );
    }
    public static PropertyModel mapToPropertyModel(Property property){
        return new PropertyModel(
//                property.getId(),
//                property.getAddress(),
//                property.getNumberOfRooms(),
//                property.getLocality(),
//                property.getRent(),
//                property.getOwner()
        );
    }
}
