package tech.vishal.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tech.vishal.Entity.EmpEntity;
import tech.vishal.Repo.EmpRepo;
import tech.vishal.service.AppService;


@Component
public class AppRunner implements ApplicationRunner{

//	
//	AppService appser;
//	
//	@Autowired
//	public void setAppServcie(AppService appser) {
//		this.appser=appser;
//	}
//	
//	
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		
//		EmpEntity emp = new EmpEntity(1,"vishal");
//		appser.save(emp);
//		System.out.println("order ==========================");
//		
////		appser.orderId(1);
//		
////		Object orderId1 = appser.orderId1(1);
//		System.out.println("Saved Employee ID: " + emp.getEmpId()); // Print the generated ID
//
//        // Now retrieve the entity by ID
//        EmpEntity retrievedEmp = appser.orderId(emp.getEmpId());
//        if (retrievedEmp != null) {
//            System.out.println("Retrieved Employee: " + retrievedEmp.getName());
//        } else {
//            System.out.println("Employee not found.");
//        } 
//		
//	}
//	
//	
	private final AppService appser;

    @Autowired
    public AppRunner(AppService appser) {
        this.appser = appser;
    }

    @Autowired
    EmpRepo empRepo;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create an EmpEntity with a manually specified ID and name
        EmpEntity emp = new EmpEntity(1, "vishal"); // Manually set empId to 1
        appser.save(emp); // Save the entity
        
//        System.out.println("Saved Employee ID: " + emp.getEmpId()); // Print the saved ID

        
        List<EmpEntity> empAdd = new ArrayList<>();
        
        empAdd.add(new EmpEntity(2,"vishal singh"));
        empAdd.add(new EmpEntity(3,"vishal rajput"));
        empAdd.add(new EmpEntity(4,"vishal thakur"));
        empAdd.add(new EmpEntity(5,"vishu"));

        empRepo.saveAll(empAdd);
        
        
        
        // Now retrieve the entity by ID
        EmpEntity retrievedEmp = appser.orderId(emp.getEmpId());
        if (retrievedEmp != null) {
            System.out.println("Retrieved Employee: ID = " + retrievedEmp.getEmpId() + ", Name = " + retrievedEmp.getName());
        } else {
            System.out.println("Employee not found.");
        }
        
        Optional<EmpEntity> byId = empRepo.findById(2);
        if(byId.isPresent()) {
        	EmpEntity empEntity = byId.get();
        	System.out.println("id :::::"+empEntity.getEmpId()+" Name ::::"+empEntity.getName());
        }
        
        
        EmpEntity empEntity = empRepo.findById(3).orElse(null);
        if(empEntity != null) {
        	System.out.println("Employee Found Id :::"+empEntity.getEmpId()+"  name ::::"+empEntity.getName());
        }else {
        	System.out.println("Not found it ");
        }
        
        
        
        
    }
}
