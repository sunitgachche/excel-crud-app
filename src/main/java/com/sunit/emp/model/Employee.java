package com.sunit.emp.model;


import lombok.Data;

@Data
public class Employee {
	
	private static int idCounter = 1;
	
	 private int id;
	    private String name;
	    private String department;
	    private double salary;
	    
	    public Employee() {
	        this.id = idCounter++;
	    }

}