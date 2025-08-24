package com.example.repo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

@Repository
public class EmployeeReposotroy {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void save(Employee emp) {
		jdbcTemplate.update("INSERT INTO NAMES VALUES(?,?,?,?,?)",emp.getEmpNo(),emp.geteName(),emp.getSal(),emp.getDep(),emp.getAge());
	}
	
	
	public void findById(int id) {
		Map<String ,Object> example = jdbcTemplate.queryForMap("SELECT * FROM NAMES WHERE EMPNO=?",id);
		example.forEach((K, V) -> System.out.println(K+" : "+V));
//		example.forEach(System.out::println); we cannot used this 
	}
	
	
}
