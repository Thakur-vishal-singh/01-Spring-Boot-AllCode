package com.example.repo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class EmpRepo {

	
	@Autowired
	SimpleJdbcCall simpleJdbcCall;
	
	
	public void getBonus(int empId) {
		
		simpleJdbcCall
		.withFunctionName("return_bonus");
		
		Map<String, Object> example = simpleJdbcCall.execute(empId);

		example.forEach((K,V) -> System.out.println(K+":"+V));
		
	}

}

		// jdbc will register by the spring-boot-stater-jdbc autoConfiguration 
		
//		@Autowired
//		SimpleJdbcCall sJdbcCall; // this will not register we have to register it how to do that ? by using @Bean and beans is where we can write in @Configuration class 
//	 	
//		public void getBonus(int empId) {
//			
//			//specify the function name of the Data-Source 
//			sJdbcCall.withFunctionName("return_bonus");
//									  //return_bonus
//			
//			Map<String, Object> output =sJdbcCall.execute(empId);
//		
//			output.forEach((K,V) -> System.out.println(K+""+V));
//			
//			// stream direct not support to the map we should use the value key or entrySet
//		output.entrySet().forEach(System.out::println);
//
//		}
//	}
