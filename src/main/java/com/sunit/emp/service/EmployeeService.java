package com.sunit.emp.service;

import java.util.List;

import com.sunit.emp.model.Employee;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

     Employee getEmployeeById(int id);

    Employee updateEmployee(Employee updatedEmployee);

    List<Employee> getAllEmployees();
    public void deleteEmployee(int id);
}