/**
 * 
 */
package com.hcl.homeinsurance.property.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hcl.homeinsurance.property.utility.ApplicationConstants;

/**
 * @author User1
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


	  @ExceptionHandler(PropertyNotFoundException.class) public
	  ResponseEntity<ErrorResponse> error(PropertyNotFoundException ex) {
	  
	  ErrorResponse er = new ErrorResponse(); 
	  er.setMessage(ex.getMessage());
	  er.setStatus(ApplicationConstants.PROPERTY_FAILURE_CODE); 
	  return
	  new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
	  
	  }
	  @Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
			List<Object> detail = new ArrayList<>();
			for (ObjectError error : ex.getBindingResult().getAllErrors()) {
				detail.add(error.getDefaultMessage());

			}
			InputErrorResponse errorResponse = new InputErrorResponse(detail, "validation");

			return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
		}
	 
	 
}
