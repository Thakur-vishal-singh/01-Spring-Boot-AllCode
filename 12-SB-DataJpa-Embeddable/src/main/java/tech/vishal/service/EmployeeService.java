package tech.vishal.service;

import java.util.List;
import java.util.Optional;

import tech.vishal.entity.Address;
import tech.vishal.entity.Employee;

public interface EmployeeService {

  void saveEmployee(Employee employee);	
	
  Address saveAddress(String houseNo, String street, String city, Integer pincode);  
  
  Address saveAddres(Address address);

  Optional<Employee> getEmployeeById(Integer id);
  
  Employee updateEmployeeId(Employee updateEmployee);
  
  void deleteEmployeeById(Integer id);
  
   Iterable<Employee> saveAllEmp(List<Employee> emp);
   
}
