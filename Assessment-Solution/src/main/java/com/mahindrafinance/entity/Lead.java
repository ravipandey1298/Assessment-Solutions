package com.mahindrafinance.entity;

import java.time.LocalDate;
import java.util.Objects;

import com.mahindrafinance.dto.LeadDTO;
import com.mahindrafinance.utility.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Entity
public class Lead {

	@Id
	@NotNull
	private Integer leadId;
	@NotNull
	@Pattern(regexp = "[A-Za-z]+")
	private String firstName;
	@Pattern(regexp = "[A-Za-z]+")
	private String middleName;
	@NotNull
	@Pattern(regexp = "[A-Za-z]+")
	private String lastName;
	@NotNull
	@Pattern(regexp = "[6-9]{1}[0-9]{9}")
	private String mobileNumber;
	@NotNull
	private Gender gender;
	@NotNull
	@Past
	private LocalDate dob;
	@Email
	private String email;

	public Integer getLeadId() {
		return leadId;
	}

	public void setLeadId(Integer leadId) {
		this.leadId = leadId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Lead leadValueOf(LeadDTO leadDTO) {
		Lead lead = new Lead();
		lead.setLeadId(leadDTO.getLeadId());
		lead.setFirstName(leadDTO.getFirstName());
		lead.setMiddleName(leadDTO.getMiddleName());
		lead.setLastName(leadDTO.getLastName());
		lead.setMobileNumber(leadDTO.getMobileNumber());
		lead.setGender(leadDTO.getGender());
		lead.setDob(leadDTO.getDob());
		lead.setEmail(leadDTO.getEmail());
		return lead;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dob, email, firstName, gender, lastName, leadId, middleName, mobileNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lead other = (Lead) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && gender == other.gender
				&& Objects.equals(lastName, other.lastName) && Objects.equals(leadId, other.leadId)
				&& Objects.equals(middleName, other.middleName) && Objects.equals(mobileNumber, other.mobileNumber);
	}

	@Override
	public String toString() {
		return "Lead [leadId=" + leadId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", mobileNumber=" + mobileNumber + ", gender=" + gender + ", dob=" + dob + ", email="
				+ email + "]";
	}

}
