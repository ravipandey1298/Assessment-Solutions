package com.mahindrafinance.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.mahindrafinance.dto.LeadDTO;
import com.mahindrafinance.dto.ResponseSuccessDTO;
import com.mahindrafinance.service.LeadService;
import com.mahindrafinance.utility.Gender;

@ExtendWith(MockitoExtension.class)
public class LeadAPITest {
	
	Logger log = Logger.getLogger("LeadAPITest");
	
	@Mock
	private LeadService leadService;
	
	@InjectMocks
	private LeadAPI leadAPI;
	
	@Test
	public void testAddLeadEndpoint() {
		
		LeadDTO dto = new LeadDTO();
		dto.setLeadId(3321);
		dto.setFirstName("Vikas");
		dto.setLastName("Singh");
		dto.setMobileNumber("9876334523");
		dto.setGender(Gender.Male);
		dto.setDob(LocalDate.of(1999, 01, 01));
		dto.setEmail("vikas@gmail.com");
		
		try {
		when(leadService.addLead(dto)).thenReturn(3321);
		
		ResponseEntity<ResponseSuccessDTO> response = leadAPI.addLead(dto);
		
		Assertions.assertEquals("success", response.getBody().getStatus());
		Assertions.assertEquals("Lead added successfully.", response.getBody().getData());
		verify(leadAPI, times(1)).addLead(dto);
		}catch(Exception e) {
			log.info(e.getMessage() + e);
		}
	}
	
}
