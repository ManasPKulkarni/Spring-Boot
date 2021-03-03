package com.devSense.Tests;

public class CalTax {

	static void calculateTax(StateTax st) {
		double centralTax =1000;
			
		double stateTax = st.calStateTax();
		
		double totalTax = centralTax + stateTax;
		
		System.out.println("Total Tax is : "+ totalTax);
	}
}
