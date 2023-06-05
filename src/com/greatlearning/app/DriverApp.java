package com.greatlearning.app;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.greatlearning.model.Employee;
import com.greatlearning.service.EmployeeServiceImpl;

public class DriverApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name");
		String fName = sc.next();
		System.out.println("Enter Last Name");
		String lName = sc.next();
		
		Employee emp = new Employee();
		emp.setFirstName(fName);
		emp.setLastName(lName);
		EmployeeServiceImpl esi = new EmployeeServiceImpl();
		System.out.println("1.Technical");
		System.out.println("2.Admin");
		System.out.println("3.Human Resource");
		System.out.println("4.Legal");
		System.out.println("Enyer Your Choice");
		int choice = sc.nextInt();
		String gEmail = "";
		String gPass = "";
		switch(choice)
		{
		case 1 : gEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(), emp.getLastName().toLowerCase(), "tech");
			   break;
		case 2 :  gEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(), emp.getLastName().toLowerCase(), "admin");
			   break;
		case 3 :  gEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(), emp.getLastName().toLowerCase(), "humanresource");
			   break;
		case 4 :  gEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(), emp.getLastName().toLowerCase(), "legal");
			   break;
		default: System.out.println("Please Enter Valid Input");	   
		}
		gPass = esi.generateUserPassword();
		emp.setUserEmail(gEmail);
		emp.setPassword(gPass);
		esi.displayEmployeeDetails(emp);
		
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)" + "(?=.*[-+_!@#$%^&*., ?]).+$"; // for checking password is either valid or invalid
		
		Pattern p = Pattern.compile(regex);
		 Matcher m = p.matcher(gPass);
		 if (m.matches())
		            System.out.println("Valid Password");
		        else
		            System.out.println("inValid Password");
	}
}
