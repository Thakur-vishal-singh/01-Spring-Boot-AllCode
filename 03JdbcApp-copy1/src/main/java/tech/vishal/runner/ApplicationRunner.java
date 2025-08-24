package tech.vishal.runner;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import tech.vishal.Servcie.ApplicationServices;


@Component
@Order(value = 1)
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {

	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	ApplicationServices applicationService;
	
	@Autowired
	ApplicationServices ser;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("First runner componen is running");
		
		
		jdbc.execute("drop tables if exists orders");
		
		jdbc.execute("create table orders(orderId int,orderName varchar(20),orderQun int, primary key(orderId))");
		
		jdbc.update("insert into orders values(1,'box',2)");
		jdbc.update("insert into orders values(2,'folder',4)");
		jdbc.update("insert into orders values(3,'mobile',1)");
		jdbc.update("insert into orders values(4,'headphone',2)");
		jdbc.update("insert into orders values(5,'ring',4)");
		jdbc.update("insert into orders values(6,'glass',1)");
		
		System.out.println("insert success");
		
//		ser.printAll();
		
	}

	
	
	
}
