package tech.vishal.repo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tech.vishal.Entity.EmpEntity;


@Repository
public class EmpRepo {

	
	@Autowired
	JdbcTemplate  jdbcTemplate;
	
	
	public void createTable() {
		String querydrop ="drop table if exists example_1";
		jdbcTemplate.execute(querydrop);
		String query = "create table example_1(empId int primary key, empName varchar(20),empEmail varchar(30))";
		jdbcTemplate.execute(query);
	}
	
	public void findById(int empId) {
		String 	query = "select * from example_1 where empId = ?"; 
	    Map<String , Object> find = jdbcTemplate.queryForMap(query,empId);
	     find.forEach((K,V) -> System.out.println(K+":"+V));
	    
	}
	
	
	
	public void updateNameBasedOnId(int id,String name) {
		String query = "update example_1 set name = ? where empId = ?";
		jdbcTemplate.update(query,name,id);
	}
	
	
	
	public void findAll() {
		String query = "select * from example_1";
		List<Map<String,Object>> runAll = jdbcTemplate.queryForList(query);
		
		for(Map<String, Object> ex : runAll) {
			ex.forEach((k,v)-> System.out.println(k+":"+v));
		}
		
	}
	
	
	public void save(EmpEntity emp) {
		String query = "insert into example_1 values(?,?,?)";
		jdbcTemplate.update(query,emp.getId(),emp.getName(),emp.getEmail());
	}
	
	
	
	public void findByEmail(String email) {
		String query="select * from example_1 where empEmail=?";
		Map<String, Object> example = jdbcTemplate.queryForMap(query,email);
		example.forEach((K,V) -> System.out.println(K+""+V));
	}
	
	
	
}