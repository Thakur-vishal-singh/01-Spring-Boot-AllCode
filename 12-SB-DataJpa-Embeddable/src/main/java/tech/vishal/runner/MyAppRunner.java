package tech.vishal.runner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tech.vishal.entity.Address;
import tech.vishal.entity.Employee;
import tech.vishal.service.EmployeeService;

@Component
public class MyAppRunner implements ApplicationRunner{

	@Autowired
	private EmployeeService employeeService;  
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
	saveData();
		
	saveAllData();
	
	updateData();
	
	deleteById();
		
	}

	
	private void deleteById() {
	employeeService.deleteEmployeeById(7718);
	}


	private void updateData() {
		Address address = employeeService.saveAddress("3-110", "Ameerpet","Hyderabad",1123);
		Employee empUpdate = new Employee(1188,"mike",10000.0,address);
		employeeService.updateEmployeeId(empUpdate);
		
	}
	
	private void saveAllData() {
Address address = employeeService.saveAddress("3-110", "Ameerpet","Hyderabad",1123);
Address address1 = employeeService.saveAddress("2-110", "nm guda","Hyderabad",1113);
Address address2 = employeeService.saveAddress("3-1111", "ram bag","Hyderabad",1111);
Address address3 = employeeService.saveAddress("9-110", "ameenput","Hyderabad",1003);
		
		Employee emp = Employee.builder()
							.id(1188)
							.ename("cotte")
							.sal(70000.0)
							.address(address)
							.build();
		
		Employee emp1 = Employee.builder()
				.id(7711)
				.ename("rambo")
				.sal(30000.0)
				.address(address1)
				.build();
		
		Employee emp2 = Employee.builder()
				.id(7718)
				.ename("ramo")
				.sal(90000.0)
				.address(address2)
				.build();
		
		
		Employee emp3 = Employee.builder()
				.id(7781)
				.ename("vicky")
				.sal(90000.0)
				.address(address3)
				.build();
		
		List<Employee> all = Arrays.asList(emp,emp1,emp2,emp3);
		
		Iterable<Employee> saveAllEmp = employeeService.saveAllEmp(all);
		
		saveAllEmp.forEach(System.out::println);
		
	}





	void saveData() {
//Address address = employeeService.saveAddress("3-110", "Ameerpet","Hyderabad",1123);
		
		Address address1 =  new  Address("101","patancheru","hyderabad",12233);
		
//		Address saveAddres = employeeService.saveAddres(address1);
		
		Employee emp = Employee.builder()
							.id(7788)
							.ename("scott")
							.sal(60000.0)
							.address(address1)
							.build();
		
		employeeService.saveEmployee(emp);
		
		System.out.println("Employee Saved successfully");
		
	}
	
	
}