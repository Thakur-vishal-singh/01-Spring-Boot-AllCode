package tech.vishal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.vishal.entity.Address;
import tech.vishal.entity.Employee;
import tech.vishal.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
		EmployeeRepository empRepo;
	
	@Override
	public Address saveAddress(String houseNo, String street, String city, Integer pincode) {
		return new Address(houseNo, street, city, pincode);
	}
	
	@Override
	public void saveEmployee(Employee employee) {
	empRepo.save(employee);
	}
	
	@Override
	public Address saveAddres(Address address) {
		return new Address(address.getHouseNo(), address.getStreet(), address.getCity(), address.getPincode());
	}
	
	@Override
	public void deleteEmployeeById(Integer id) {
	empRepo.deleteById(id);
	}
		
	
	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		return empRepo.findById(id);
	}
	
	@Override
	public Employee updateEmployeeId(Employee updateEmployee) {

		if(empRepo.existsById(updateEmployee.getId())){
				return empRepo.save(updateEmployee);
	}
		throw new RuntimeException("Employee with id"+updateEmployee.getId()+" not founded" );
	}
		
	@Override
	public Iterable<Employee> saveAllEmp(List<Employee> emp) {
		Iterable<Employee> saveAll = empRepo.saveAll(emp);
		return saveAll;
	}
	
	
	

}
