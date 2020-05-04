/**
 * 
 */
package com.hcl.homeinsurance.property.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author User1
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
	T detail;
	
	private int statusCode;
	private String message;
	
	

}
