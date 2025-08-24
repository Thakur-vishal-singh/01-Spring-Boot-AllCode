package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repo.EmpRepo;


@Service
public class EmpService {

	
	@Autowired
	EmpRepo empRepo;
	
	public void readBonus(int empId) {
		empRepo.getBonus(empId);
	}
	
	
}