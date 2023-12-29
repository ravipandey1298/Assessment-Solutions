package com.mahindrafinance.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.mahindrafinance.dto.LeadDTO;
import com.mahindrafinance.service.LeadServiceImpl;
import com.mahindrafinance.utility.Gender;

public class LeadServiceImplTest {
	
	Logger log = Logger.getLogger("LeadServiceImplTest");
	
	@InjectMocks
	private LeadServiceImpl leadServiceImpl;
	
	@Test
	public void testAddLead() {
		LeadDTO dto = new LeadDTO();
		dto.setLeadId(3321);
		dto.setFirstName("Vikas");
		dto.setLastName("Singh");
		dto.setMobileNumber("9876334523");
		dto.setGender(Gender.Male);
		dto.setDob(LocalDate.of(1999, 01, 01));
		dto.setEmail("vikas@gmail.com");
		
		try {
		Integer result = leadServiceImpl.addLead(dto);
		assertEquals(dto.getLeadId(), result);
		}catch(Exception e) {
			log.info(e.getMessage() + e);
		}
	}
}
