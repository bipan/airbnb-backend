package com.pw.airbnb.controller;

import com.pw.airbnb.entity.Property;
import com.pw.airbnb.exception.ResourceNotFoundException;
import com.pw.airbnb.service.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airbnb/api/v1/properties")
@CrossOrigin("http://localhost:4200/")
public class PropertyController {
    private final PropertyService propertyService;
    public PropertyController(PropertyService propertyService){
        this.propertyService = propertyService;
    }
    @PostMapping
    public String saveProperty(@RequestBody Property property){
        return propertyService.saveProperty(property);
    }
    @GetMapping
    public List<Property> getAllProperty(){
        return propertyService.getAllProperty();
    }
    @DeleteMapping("/{id}")
    public String deleteProperty(@PathVariable("id") Long id) {
        return propertyService.deleteProperty(id);
    }
    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable("id") Long sid) throws Exception {
        return propertyService.getPropertyById(sid);
    }

    @PutMapping("/update/{id}")
    public String editProperty(@PathVariable("id") Long id, @RequestBody Property property) throws ResourceNotFoundException {
        return propertyService.editProperty(id, property);
    }
}
