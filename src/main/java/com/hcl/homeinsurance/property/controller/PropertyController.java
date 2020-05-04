package com.hcl.homeinsurance.property.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.homeinsurance.domain.PropertyEntity;
import com.hcl.homeinsurance.property.dto.PropertyDto;
import com.hcl.homeinsurance.property.dto.ResponseDto;
import com.hcl.homeinsurance.property.entity.Property;
import com.hcl.homeinsurance.property.exception.PropertyNotFoundException;
import com.hcl.homeinsurance.property.service.PropertyService;

@RestController
@RequestMapping("properties")
public class PropertyController {
	
	  @Autowired PropertyService propertyService;
	 
	
	
	@GetMapping("/")
	public ResponseEntity<List<Property>> getAllPropertyDetail() throws PropertyNotFoundException
	{
		return new ResponseEntity<List<Property>>(propertyService.getAllProperty(),HttpStatus.FOUND);
	}
	
	@GetMapping("/{user_id}")
	public ResponseEntity<PropertyEntity> getPropertyDetailById(@PathVariable("user_id") long propertyId) throws PropertyNotFoundException
	{
		return new ResponseEntity<PropertyEntity>(propertyService.getPropertyDetailById(propertyId),HttpStatus.FOUND);
	}
	
	@PostMapping("/{user_id}")
	public ResponseEntity<ResponseDto<?>> registerProperty(@PathVariable("user_id") long userId,@RequestBody PropertyEntity entity)
	{
		
		return new ResponseEntity<ResponseDto<?>>(propertyService.register(userId, entity),HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/{user_id}")
	public ResponseEntity<ResponseDto<?>> updateProperty(@PathVariable("user_id") long userId,@RequestBody PropertyEntity entity) throws PropertyNotFoundException
	{
		
		return new ResponseEntity<ResponseDto<?>>(propertyService.updateProperty(userId, entity),HttpStatus.ACCEPTED);
	}
	
	
	
}