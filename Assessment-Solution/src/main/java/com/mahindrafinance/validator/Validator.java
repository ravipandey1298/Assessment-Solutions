package com.mahindrafinance.validator;

import com.mahindrafinance.dto.LeadDTO;

public class Validator {
	
	public void validateLead(LeadDTO leadDTO) throws Exception {
		if(!isValidName(leadDTO.getFirstName()))
			throw new Exception("Invalid Value. Name contains only Alphabets.");
		
		if(leadDTO.getMiddleName() != null && !isValidName(leadDTO.getMiddleName()))
			throw new Exception("Invalid Value. Name contains only Alphabets.");
		
		if(!isValidName(leadDTO.getLastName()))
			throw new Exception("Invalid Value. Name contains only Alphabets.");
		
		if(!isValidMobileNumber(leadDTO.getMobileNumber().toString()))
			throw new Exception("Invalid Mobile Number. Mobile Number should not more than 10 and First Number is start from more than 5.");
		
		if(!isValidEmail(leadDTO.getEmail()))
			throw new Exception("Invalid Email. Use Correct Email");
	}
	
	public Boolean isValidName(String firstName) {
		String regex = "[A-Za-z]+";
		return firstName.matches(regex) ? true : false;
	}
	
	public Boolean isValidMobileNumber(String mobileNumber) {
		String regex = "[6-9]{1}[0-9]{9}";
		return mobileNumber.matches(regex) ? true : false;
	}
	
	public Boolean isValidEmail(String email) {
		String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
		        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		return email.matches(regex) ? true : false;
	}
	
}
