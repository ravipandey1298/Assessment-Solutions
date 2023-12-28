package com.mahindrafinance.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseSuccessDTO {
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("data")
	private String data;
	
	@JsonProperty("datas")
	private List<?> dataAsList;
	
	public ResponseSuccessDTO() {
		
	}
	
	public ResponseSuccessDTO(String status, String data) {
		this.data = data;
		this.status = status;
	}
	
	public ResponseSuccessDTO(String status, List<?> dataAsList) {
		this.dataAsList = dataAsList;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<?> getDataAsList() {
		return dataAsList;
	}

	public void setData(List<?> dataAsList) {
		this.dataAsList = dataAsList;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}
	
}
