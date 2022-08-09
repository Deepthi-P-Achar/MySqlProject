package com.example.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.web.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
@Query("select e1 from Employee e1 join Employee e2 on e1.managerId=e2.id where e1.salary>e2.salary")
public List<Employee> findAllTheEmpHavingSalGtThanManager();
	
}
