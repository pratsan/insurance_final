package com.hcl.homeinsurance.property.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.homeinsurance.domain.PropertyEntity;
import com.hcl.homeinsurance.property.dto.PropertyDto;
import com.hcl.homeinsurance.property.dto.ResponseDto;
import com.hcl.homeinsurance.property.entity.Property;
import com.hcl.homeinsurance.property.exception.PropertyNotFoundException;

@Service
public interface PropertyService {
public List<Property> getAllProperty() throws PropertyNotFoundException;
public PropertyEntity getPropertyDetailById(Long propertyId)throws PropertyNotFoundException;

public ResponseDto<?> register(Long userId,PropertyEntity entity);

public ResponseDto<?> updateProperty(Long userId,PropertyEntity entity)throws PropertyNotFoundException;
}