package com.sunit.emp.service.Impl;

//EmployeeServiceImpl.java
import org.springframework.stereotype.Service;

import com.sunit.emp.model.Employee;
import com.sunit.emp.service.EmployeeService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Service
public class EmployeeServiceImpl implements EmployeeService {
 private static final String FILE_NAME = "C://Users/Sunit/Downloads/employees.xlsx";

 private List<Employee> employees = new ArrayList<>();

 @Override
 public Employee addEmployee(Employee employee) {
     employees.add(employee);
     writeToExcel(employees);
     return employee;
 }

 
 @Override
 public Employee getEmployeeById(int id) {
     for (Employee employee : employees) {
         if (employee.getId() == id) {
             return employee;
         }
     }
     return null;
 }
 

 @Override
 public Employee updateEmployee(Employee updatedEmployee) {
     List<Employee> employees = getAllEmployees();
     for (Employee employee : employees) {
         if (employee.getId() == updatedEmployee.getId()) {
             employee.setName(updatedEmployee.getName());
             employee.setDepartment(updatedEmployee.getDepartment());
             employee.setSalary(updatedEmployee.getSalary());
             // Update other fields as needed
             writeToExcel(employees);
             return employee;
         }
     }
     return null;
 }
 @Override
 public List<Employee> getAllEmployees() {
     return employees;
 }
 
 @Override
 public void deleteEmployee(int id) {
     employees.removeIf(employee -> employee.getId() == id);
     writeToExcel(employees);
 }

 // Helper method to write the data to the Excel file
 private void writeToExcel(List<Employee> employees) {
     try (Workbook workbook = new XSSFWorkbook()) {
         Sheet sheet = workbook.createSheet("Employees");
         
         // Create the header row and set column names
         Row headerRow = sheet.createRow(0);
         headerRow.createCell(0).setCellValue("ID");
         headerRow.createCell(1).setCellValue("Name");
         headerRow.createCell(2).setCellValue("Department");
         headerRow.createCell(3).setCellValue("Salary");
         int rowNum = 1;

         for (Employee employee : employees) {
             Row row = sheet.createRow(rowNum++);
             row.createCell(0).setCellValue(employee.getId());
             row.createCell(1).setCellValue(employee.getName());
             row.createCell(2).setCellValue(employee.getDepartment());
             row.createCell(3).setCellValue(employee.getSalary());
             // Set other fields as needed
         }

         try (FileOutputStream outputStream = new FileOutputStream(FILE_NAME)) {
             workbook.write(outputStream);
         }
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
}
