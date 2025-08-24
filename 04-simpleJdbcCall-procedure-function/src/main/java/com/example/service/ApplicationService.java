package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repo.ApplicationRepo;

@Service
public class ApplicationService {

	
	@Autowired
	ApplicationRepo empRepo;
	
	
	public void redBound(int empid) {
		empRepo.getBonus(empid);
	}
	
	
}
