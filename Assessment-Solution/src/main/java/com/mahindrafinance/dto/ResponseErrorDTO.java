package com.mahindrafinance.dto;

public class ResponseErrorDTO {
	private String status;
	
	private ErrorResponseDTO errorResponse;
	
	public ResponseErrorDTO() {
		
	}
	
	public ResponseErrorDTO(String status, ErrorResponseDTO errorResponse) {
		this.status = status;
		this.errorResponse = errorResponse;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ErrorResponseDTO getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponseDTO errorResponse) {
		this.errorResponse = errorResponse;
	}
	
}
