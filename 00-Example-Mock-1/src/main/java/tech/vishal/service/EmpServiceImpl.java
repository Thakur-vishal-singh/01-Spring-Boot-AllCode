package tech.vishal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.vishal.Entity.EmpEntity;
import tech.vishal.repo.EmpRepo;


@Service
public class EmpServiceImpl implements EmpService {

	
	@Autowired EmpRepo empRepo;
	
	
	@Override
	public void creatTable() {
	empRepo.createTable();
	}
	
	
	@Override
	public void findByEmail(String email) {
	 empRepo.findByEmail(email);
	}

	
	@Override
	public void findEmpById(int id) {
	 empRepo.findById(id);
	}
	
	@Override
	public void save(EmpEntity emp) {
	 empRepo.save(emp);	
	}
	
	@Override
	public void updateByIdName(int id, String name) {
	empRepo.updateNameBasedOnId(id, name);
	}

}
