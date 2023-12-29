package com.mahindrafinance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mahindrafinance.dto.LeadDTO;
import com.mahindrafinance.dto.ResponseSuccessDTO;
import com.mahindrafinance.entity.Lead;
import com.mahindrafinance.service.LeadService;

@RestController
@RequestMapping(value = "/mahindrafinance")
public class LeadAPI {
	
	@Autowired
	LeadService leadService;
	
	@PostMapping(value = "/addCustomer")
	public ResponseEntity<ResponseSuccessDTO> addLead(@RequestBody LeadDTO leadDTO) throws Exception{
		leadService.addLead(leadDTO);
		ResponseSuccessDTO response = new ResponseSuccessDTO("success", "Lead added successfully.");
		return new ResponseEntity<ResponseSuccessDTO>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getLeads")
	public ResponseEntity<ResponseSuccessDTO> getLeads(@RequestParam("mobileNumber") Long mobileNumber){
		try {
			List<Lead> leads = leadService.getLeads(mobileNumber);
			ResponseSuccessDTO response = new ResponseSuccessDTO("success", leads);
			return new ResponseEntity<ResponseSuccessDTO>(response, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}
}
