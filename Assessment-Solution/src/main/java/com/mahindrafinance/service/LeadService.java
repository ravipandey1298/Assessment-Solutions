package com.mahindrafinance.service;

import java.util.List;

import com.mahindrafinance.dto.LeadDTO;
import com.mahindrafinance.entity.Lead;

public interface LeadService {
	
	public Integer addLead(LeadDTO leadDTO) throws Exception ;

	public List<Lead> getLeads(Long mobileNumber) throws Exception;

}
