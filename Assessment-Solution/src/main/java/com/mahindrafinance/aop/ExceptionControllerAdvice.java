package com.mahindrafinance.aop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.mahindrafinance.dto.ErrorResponseDTO;
import com.mahindrafinance.dto.ResponseErrorDTO;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<ResponseErrorDTO> exceptionHandler(ResponseStatusException exception){
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setCode(exception.getStatusCode().toString());
		errorResponseDTO.setMessage(exception.getMessage().substring(exception.getMessage().indexOf('"')+1, exception.getMessage().lastIndexOf('"')));
		
		ResponseErrorDTO error = new ResponseErrorDTO();
		error.setStatus("erorr");
		error.setErrorResponse(errorResponseDTO);
		
		
		return new ResponseEntity<ResponseErrorDTO>(error, exception.getStatusCode());
	}
}