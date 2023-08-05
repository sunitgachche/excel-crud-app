package com.sunit.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
//EmployeeController.java
import org.springframework.web.bind.annotation.*;

import com.sunit.emp.model.Employee;
import com.sunit.emp.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;


 @PostMapping("/add")
 public Employee addEmployee(@RequestBody Employee employee) {
     employeeService.addEmployee(employee);
     return employee;
 }

 @GetMapping("/get/{id}")
 public Employee getEmployee(@PathVariable int id) {
   return  employeeService.getEmployeeById(id);

    
 }

 @PutMapping("/update/{id}")
 public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
     updatedEmployee.setId(id);
     return employeeService.updateEmployee(updatedEmployee);
 }

 @GetMapping("/getall")
 public List<Employee> getAllEmployees() {
	 
	return  employeeService.getAllEmployees();
     
 }
 @DeleteMapping("/delete/{id}")
 public String deleteRecord(@PathVariable Integer id) {
	 employeeService.deleteEmployee(id);
	return "deleted successfully...!";
	 
 }


}
