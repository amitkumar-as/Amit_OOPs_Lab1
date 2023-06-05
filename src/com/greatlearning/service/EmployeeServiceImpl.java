package com.greatlearning.service;

import java.util.Random;

import com.greatlearning.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public String generateUserEmail(String firstName, String lastName, String departmentName) {
		
		return firstName + lastName + "@" + departmentName + ".greatlearning.com";
	}

	@Override
	public String generateUserPassword() {
		String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = "abcdefghijklmnopqrstuvwxyz";
		String nums = "0123456789";
		String splChar = "!@#$%^&*()";
		String combined = caps + lower + nums + splChar;
//		System.out.println(combined.length());
		String password = "";
		Random random = new Random();
		
		for(int i=1;i<8;i++) {
			password += String.valueOf(combined.charAt(random.nextInt(combined.length())));
			
		}
		return password;
	}

	@Override
	public String displayEmployeeDetails(Employee e1) {
	  System.out.println("Employee firstName is: " + e1.getFirstName());
	  System.out.println("Employee lastNasme is: " + e1.getLastName());
	  System.out.println("Employee Email Id is: " + e1.getUserEmail());
	  System.out.println("Employee Password is: " + e1.getPassword());
		return null;
	}

}
