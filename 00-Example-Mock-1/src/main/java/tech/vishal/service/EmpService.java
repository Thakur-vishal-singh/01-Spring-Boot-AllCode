package tech.vishal.service;

import tech.vishal.Entity.EmpEntity;

public interface EmpService {

	public void creatTable();
	
	public void save(EmpEntity emp);
	
	public void findEmpById(int id);
	
	public void findByEmail(String email);
	
	public void updateByIdName(int id,String name);
	
	
}
