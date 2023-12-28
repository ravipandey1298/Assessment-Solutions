package com.mahindrafinance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahindrafinance.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Integer>{
	
	public List<Lead> findByMobileNumber(String mobileNumber);
}
