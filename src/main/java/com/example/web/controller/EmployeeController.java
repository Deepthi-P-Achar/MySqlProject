package com.example.web.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.dao.EmployeeRepository;
import com.example.web.model.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository repo;
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid Employee emp) {
		return ResponseEntity.ok().body(repo.save(emp));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> findAllEmployees() {
		return ResponseEntity.ok().body(repo.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee>  findEmployeeById(@PathVariable("id") long id) {
		Optional<Employee> emp=repo.findById(id);
		if(emp.isPresent()) { 
			return ResponseEntity.ok().body(emp.get());
		}else
			return ResponseEntity.notFound().build();
		
		
	}
	
	@GetMapping("/salary/gt/manager")
	public ResponseEntity<List<Employee>> findAllTheEmpHavingSalGtThanManager() {
		return ResponseEntity.ok().body(repo.findAllTheEmpHavingSalGtThanManager());
		
	}
}
