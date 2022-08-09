package com.example.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    private String name;
    @Range(min=1500000, max=2500000)
    private double salary;
    private int managerId;
    
   public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
public Employee(int id,String name, double salary, String department, int managerId) {
		super();
		this.id=id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.managerId=managerId;
	}

public Employee() {
	super();
}

   private String department;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
}
