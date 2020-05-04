package com.hcl.homeinsurance.property.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "address_info")

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id", unique = true, nullable = false)
 
    private Long addressId;

    
 
    @OneToOne(targetEntity = Property.class,cascade = CascadeType.ALL)
 @JoinColumn(name = "property_id") 
    private Property propertyId;
 
    @NotEmpty(message = "address must not be empty")
    @Column(name = "address", length = 45)
    private String address;
    @NotEmpty(message = "state must not be empty")
    @Column(name = "state", length = 45)
    private String state;

 
    @NotEmpty(message = "city must not be empty")
    @Column(name = "city", length = 45)
    private String city;
    @NotEmpty(message = "zip must not be empty")
    @Column(name = "zip", length = 45)
    private String zip;

 
    @NotEmpty(message = "resdience must not be empty")
    @Column(name = "resdience_use", length = 45)
    private String resdienceUse;

 
    @NotEmpty(message = "resdience_type must not be empty")
    @Column(name = "resdience_type", length = 45)
    private String resdienceType;
    
  

 
    @NotEmpty(message = "address_line_2 must not be empty")
    @Column(name = "address_line_2", length = 45)
    private String addressLine2;

    public Property getPropertyId() {
		return propertyId;
	}



	public void setPropertyId(Property propertyId) {
		this.propertyId = propertyId;
	}

    public Long addressId() {
        return addressId;
    }

 

    public void addressId(Long addressId) {
        this.addressId = addressId;
    }

 

    public String getAddress() {
        return address;
    }

 

    public void setAddress(String address) {
        this.address = address;
    }

 

    public String getState() {
        return state;
    }

 

    public void setState(String state) {
        this.state = state;
    }

 

    public String getCity() {
        return city;
    }

 

    public void setCity(String city) {
        this.city = city;
    }

 

    public String getZip() {
        return zip;
    }

 

    public void setZip(String zip) {
        this.zip = zip;
    }

 

    public String getResdienceUse() {
        return resdienceUse;
    }

 

    public void setResdienceUse(String resdienceUse) {
        this.resdienceUse = resdienceUse;
    }

 

    public String getResdienceType() {
        return resdienceType;
    }

 

    public void setResdienceType(String resdienceType) {
        this.resdienceType = resdienceType;
    }

 

   

 

    public Long getAddressId() {
		return addressId;
	}



	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}



	



	public String getAddressLine2() {
        return addressLine2;
    }

 

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
}