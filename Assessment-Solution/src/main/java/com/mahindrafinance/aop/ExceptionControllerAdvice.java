package com.mahindrafinance.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mahindrafinance.dto.ErrorResponseDTO;
import com.mahindrafinance.dto.ResponseErrorDTO;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseErrorDTO> exceptionHandler(Exception exception){
		
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setCode("E233");
		errorResponseDTO.setMessage(exception.getLocalizedMessage());
		
		ResponseErrorDTO error = new ResponseErrorDTO();
		error.setStatus("erorr");
		error.setErrorResponse(errorResponseDTO);
		
		
		return new ResponseEntity<ResponseErrorDTO>(error, HttpStatus.CONFLICT);
	}
}
