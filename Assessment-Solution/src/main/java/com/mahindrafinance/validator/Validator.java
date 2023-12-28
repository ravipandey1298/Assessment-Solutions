package com.mahindrafinance.validator;

import com.mahindrafinance.dto.LeadDTO;

public class Validator {
	
	public void validateLead(LeadDTO leadDTO) throws Exception {
		if(!isValidName(leadDTO.getFirstName()))
			throw new Exception("Invalid First Name. First Name does not contain any spaces or any integer values.");
		
		if(leadDTO.getMiddleName() != null && !isValidName(leadDTO.getMiddleName()))
			throw new Exception("abc1");
		
		if(!isValidName(leadDTO.getLastName()))
			throw new Exception("abc2");
		
		if(!isValidMobileNumber(leadDTO.getMobileNumber().toString()))
			throw new Exception("abc3");
		
		if(!isValidEmail(leadDTO.getEmail()))
			throw new Exception("xyz4");
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
	
//	public Boolean isValidGender(String gender) {
//		String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
//		        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
//		return email.matches(regex) ? true : false;
//	}

}
