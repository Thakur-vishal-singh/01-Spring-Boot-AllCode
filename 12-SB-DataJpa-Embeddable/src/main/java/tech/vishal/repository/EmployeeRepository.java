package tech.vishal.repository;

import org.springframework.data.repository.CrudRepository;

import tech.vishal.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
