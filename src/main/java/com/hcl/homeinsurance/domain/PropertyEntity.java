package com.hcl.homeinsurance.domain;

import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.hcl.homeinsurance.property.dto.ResponseDto;
import com.hcl.homeinsurance.property.entity.Property;
import com.hcl.homeinsurance.property.exception.PropertyNotFoundException;
import com.hcl.homeinsurance.property.repository.PropertyRepository;
import com.hcl.homeinsurance.property.utility.ApplicationConstants;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PropertyEntity {
	private PropertyInformationVO propertyInformationVO;

	public static Factory newFactory(PropertyRepository propertyRepository) {
		return new Factory(propertyRepository);
	}

	public static class Factory {
		private PropertyRepository propertyRepository;

		private Factory(PropertyRepository propertyRepository) {
			this.propertyRepository = propertyRepository;
		}

		public ResponseDto<?> registerProperty(Long userId, PropertyEntity entity) {
			ResponseDto responseDto=new ResponseDto<>();
			Property property = new Property();

			PropertyInformationVO vo = entity.getPropertyInformationVO();
			BeanUtils.copyProperties(vo, property);
			property.setUserId(userId);
			if (!(propertyRepository.save(property)).equals(null)) {
				
				responseDto.setMessage(ApplicationConstants.REGISTERED_SUCCESS);
				responseDto.setStatusCode(ApplicationConstants.PROPERTY_SUCCESS_CODE);
				responseDto.setDetail(property);
			} else {
				responseDto.setMessage(ApplicationConstants.REGISTERED_FAILURE);
			responseDto.setStatusCode(ApplicationConstants.PROPERTY_FAILURE_CODE);
		}
			return responseDto;
		}

		public PropertyEntity getPropertyByUserId(Long userId) throws PropertyNotFoundException {
			Optional<Property> property = propertyRepository.findByUserId(userId);
			

			if (!property.isPresent())
				throw new PropertyNotFoundException(ApplicationConstants.PROPERTY_NOT_FOUND);
			
			Property property2 = property.get();
			PropertyInformationVO propertyInformationVO = new PropertyInformationVO(property2.getDwellingStyle(),
					property2.getNumberOfFullBaths(), property2.getNumberOfHalfBaths(), property2.getPool(),
					property2.getRoofType(), property2.getSquareFootage(), property2.getTypeGarage(),
					property2.getValueOfHome(), property2.getYearWasBuilt());
			PropertyEntity propertyEntity = new PropertyEntity();
			propertyEntity.setPropertyInformationVO(propertyInformationVO);
			return propertyEntity;
		}
		
		public ResponseDto<?> updateProperty(Long userId,PropertyEntity propertyEntity) throws PropertyNotFoundException
		{
			Optional<Property> propertyObject = propertyRepository.findByUserId(userId);
			if(!propertyObject.isPresent())
				throw new PropertyNotFoundException(ApplicationConstants.PROPERTY_NOT_FOUND);
			PropertyInformationVO propertyInformationVO=propertyEntity.getPropertyInformationVO();
			Property property=propertyObject.get();
			property.setDwellingStyle(propertyInformationVO.getDwellingStyle());
			property.setNumberOfFullBaths(propertyInformationVO.getNumberOfFullBaths());
			property.setNumberOfHalfBaths(propertyInformationVO.getNumberOfHalfBaths());
			property.setPool(propertyInformationVO.getPool());
			property.setRoofType(propertyInformationVO.getRoofType());
			property.setSquareFootage(propertyInformationVO.getSquareFootage());
			property.setTypeGarage(propertyInformationVO.getTypeGarage());
			property.setValueOfHome(propertyInformationVO.getValueOfHome());
			property.setYearWasBuilt(propertyInformationVO.getYearWasBuilt());
			propertyRepository.save(property);
			ResponseDto responseDto=new ResponseDto();
			responseDto.setMessage(ApplicationConstants.REGISTERED_SUCCESS);
			responseDto.setStatusCode(ApplicationConstants.PROPERTY_SUCCESS_CODE);
			responseDto.setDetail(property);
			
			
			return responseDto;
		}
		
	
	}
}