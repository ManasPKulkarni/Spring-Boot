package com.devSense.First;

import java.util.HashSet;
import java.util.Set;

public class Show {
	private static Show INSTANCE;
	private Set<String> availableSeats;
	
	private Show() {
		availableSeats = new HashSet<>();
		availableSeats.add("1A");
		availableSeats.add("1B");
//		availableSeats.add("1C");
	}
	
	public boolean bookSeat(String seat) {
		return availableSeats.remove(seat);
	}
	
	public static Show getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Show();
		}
		return INSTANCE;
	}
}
