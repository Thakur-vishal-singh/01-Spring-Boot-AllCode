package com.example.entity;

public class Employee {

   private Integer empNo;
   
   private String eName;
	
   private Double sal;
	
   private Integer dep;
   
   private Integer age;

public Integer getEmpNo() {
	return empNo;
}

public void setEmpNo(Integer empNo) {
	this.empNo = empNo;
}

public String geteName() {
	return eName;
}

public void seteName(String eName) {
	this.eName = eName;
}

public Double getSal() {
	return sal;
}

public void setSal(Double sal) {
	this.sal = sal;
}

public Integer getDep() {
	return dep;
}

public void setDep(Integer dep) {
	this.dep = dep;
}

public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}

public Employee(Integer empNo, String eName, Double sal, Integer dep, Integer age) {
	super();
	this.empNo = empNo;
	this.eName = eName;
	this.sal = sal;
	this.dep = dep;
	this.age = age;
}

@Override
public String toString() {
	return "Employee [empNo=" + empNo + ", eName=" + eName + ", sal=" + sal + ", dep=" + dep + ", age=" + age + "]";
}
   
}
