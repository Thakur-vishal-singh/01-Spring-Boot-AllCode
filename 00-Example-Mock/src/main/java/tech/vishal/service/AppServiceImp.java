package tech.vishal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.vishal.Entity.EmpEntity;
import tech.vishal.Repo.EmpRepo;

@Service
public class AppServiceImp implements AppService{

	EmpRepo empRepo;
	
	
	@Autowired
	public AppServiceImp(EmpRepo empRepo) {
		this.empRepo=empRepo;
	}
	
//	public Object orderId1(int id) {
//		Optional<EmpEntity> example = empRepo.findById(id);
//		if(example.isPresent()) {
//			return example;
//		}
//		return false;
//	}
//
	
	@Override
	public EmpEntity orderId(int id) {
		 Optional<EmpEntity> opt = empRepo.findById(id);
		 if(opt.isPresent()) {
			 return opt.get();
		 }
		return null;
	}



	@Override
	public EmpEntity save(EmpEntity order) {
		EmpEntity save = empRepo.save(order);
		return save;
	}

}
