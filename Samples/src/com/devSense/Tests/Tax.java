package com.devSense.Tests;

import java.util.Scanner;

public class Tax {

	public static void main(String[] args) 
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name of the State: ");
		String State = sc.nextLine();
		
		Class c = Class.forName("com.devSense.Tests.Maharashtra");
		
		StateTax ref = (StateTax) c.newInstance();
		
		CalTax cal = new CalTax();
		cal.calculateTax(ref);
	}

}
