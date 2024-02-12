package com.pw.airbnb.service;

import com.pw.airbnb.entity.Property;
import com.pw.airbnb.exception.ResourceNotFoundException;
import com.pw.airbnb.repository.PropertyRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }
    public String saveProperty(@RequestBody Property property){
        Property savedProperty = propertyRepository.save(property);
        if (savedProperty != null){
            return "success";
        } else return "failed";
    }
    public List<Property> getAllProperty() {
        return propertyRepository.findAll((Sort.by(Sort.Direction.DESC, "reviews")));
    }
    public Property getPropertyById(Long id) throws Exception{
        Optional<Property> property = propertyRepository.findById(id);
        if(property.isPresent()){
            return property.get();
        }
        throw new Exception("Property having id "+id+" not found!");
    }
    public String editProperty(Long id, Property property) throws ResourceNotFoundException {
        Property existingProperty = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student doesn't exists."));
        existingProperty.setPropertyName(property.getPropertyName());
        existingProperty.setLocation(property.getLocation());
        existingProperty.setPrice(property.getPrice());
        existingProperty.setDescription(property.getDescription());
        existingProperty.setCategory(property.getCategory());
        existingProperty.setGuestCapacity(property.getGuestCapacity());
        existingProperty.setReviews(property.getReviews());
        existingProperty.setTeaserImage(property.getTeaserImage());
        propertyRepository.save(existingProperty);
        return "success";

    }

    public String deleteProperty(Long id){
        if(propertyRepository.existsById(id)){
            propertyRepository.deleteById(id);
            return ("success");
        }
        else{
            return ("property with id "+id+" couldn't be found");
        }
    }
}

