package com.mahindrafinance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.mahindrafinance.dto.LeadDTO;
import com.mahindrafinance.entity.Lead;
import com.mahindrafinance.repository.LeadRepository;
import com.mahindrafinance.validator.Validator;

import jakarta.transaction.Transactional;

@Service(value = "leadService")
@Transactional
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepository leadRepository;
	
	@Autowired
	private Environment environment;

	@Override
	public Integer addLead(LeadDTO leadDTO) throws Exception{
		try {
		Validator validator = new Validator();
		validator.validateLead(leadDTO);
		
		boolean isLeadPresent = leadRepository.existsById(leadDTO.getLeadId());
		System.out.println(isLeadPresent);
		if(isLeadPresent) 
			throw new Exception(environment.getProperty("Service.LEAD_ALREADY_PRESENT"));
		Lead lead = new Lead().leadValueOf(leadDTO);
		leadRepository.save(lead);
		return leadDTO.getLeadId();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public List<Lead> getLeads(Long mobileNumber) throws Exception {
		try {
		List<Lead> leads = leadRepository.findByMobileNumber(mobileNumber.toString());
		if(leads.isEmpty()) {
			throw new Exception(environment.getProperty("Service.LEADS_NOT_FOUND"));
		}
		return leads;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

}
