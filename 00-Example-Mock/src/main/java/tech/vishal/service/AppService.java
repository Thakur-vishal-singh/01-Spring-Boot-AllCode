package tech.vishal.service;

import tech.vishal.Entity.EmpEntity;

public interface AppService {

	public EmpEntity orderId(int id);
	
    EmpEntity save(EmpEntity order);
	
//    public Object orderId1(int id);
}
