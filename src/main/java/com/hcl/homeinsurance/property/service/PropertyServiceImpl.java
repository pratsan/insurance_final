package com.hcl.homeinsurance.property.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.homeinsurance.domain.PropertyEntity;
import com.hcl.homeinsurance.domain.PropertyEntity.Factory;
import com.hcl.homeinsurance.property.dto.PropertyDto;
import com.hcl.homeinsurance.property.dto.ResponseDto;
import com.hcl.homeinsurance.property.entity.Address;
import com.hcl.homeinsurance.property.entity.Property;
import com.hcl.homeinsurance.property.exception.PropertyNotFoundException;
import com.hcl.homeinsurance.property.repository.AddressRepository;
import com.hcl.homeinsurance.property.repository.PropertyRepository;
import com.hcl.homeinsurance.property.utility.ApplicationConstants;

@Service
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	PropertyRepository propertyRepository;
	@Autowired
	AddressRepository addressRepository;
	

	@Override
	public List<Property> getAllProperty() throws PropertyNotFoundException {
		List<Property> properties = propertyRepository.findAll();
		if (properties.isEmpty())
			throw new PropertyNotFoundException(ApplicationConstants.PROPERTY_NOT_FOUND);
		return properties;
	}

	@Override
	public PropertyEntity getPropertyDetailById(Long userId) throws PropertyNotFoundException {

		
return PropertyEntity.newFactory(propertyRepository).getPropertyByUserId(userId);
		
	}

	

	@Override
	public ResponseDto<?> register(Long userId, PropertyEntity entity) {
	
		return PropertyEntity.newFactory(propertyRepository).registerProperty(userId, entity);
	}

	@Override
	public ResponseDto<?> updateProperty(Long userId, PropertyEntity entity) throws PropertyNotFoundException {
	
		return PropertyEntity.newFactory(propertyRepository).updateProperty(userId, entity);
	}

}
