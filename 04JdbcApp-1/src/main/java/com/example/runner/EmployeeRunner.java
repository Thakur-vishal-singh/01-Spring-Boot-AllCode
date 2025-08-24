package com.example.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRunner implements ApplicationRunner {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		jdbcTemplate.execute("DROP TABLE IF EXISTS NAMES;");
		jdbcTemplate.execute("CREATE TABLE NAMES(EMPNO INT,EMPNAME VARCHAR(20),SAL DOUBLE,DEP_NO INT,AGE INT)");
	
		jdbcTemplate.update("INSERT INTO NAMES VALUES(1,'VISHAL',10000.2,10,21);");
		jdbcTemplate.update("INSERT INTO NAMES VALUES(2,'VISHAL Singh',20000.2,11,22);");
		jdbcTemplate.update("INSERT INTO NAMES VALUES(3,'VISHAL Rajput',30000.2,11,23);");
		jdbcTemplate.update("INSERT INTO NAMES VALUES(4,'Thakur VISHAL',40000.2,10,22);");
		
		
		
	}
	
}
