package com.devSense.First;

public class TestShow {
	public static void main(String []args) {
		TestShow testThreads = new TestShow();
		testThreads.go();
	}

	public void go() {
		//Create thread 1 which tries to book both seats 1A & 1B
		Thread getSeat1 = new Thread(() -> {
			ticketAgentBooks("1A");
			ticketAgentBooks("1B");
		});
		
		
		//Create thread 2 which tries to book both seats 1A & 1B
		Thread getSeat2 = new Thread(() -> {
			ticketAgentBooks("1A");
			ticketAgentBooks("1B");
		});
		
		getSeat1.start();
		getSeat2.start();
	}
	
	public void ticketAgentBooks(String seat) {
		//Create OR get the one instance of the Show class
		Show myshow = Show.getInstance();
		
		System.out.println(Thread.currentThread().getName() + " : " + myshow.bookSeat(seat));
//		myshow.bookSeat(seat);
	}
}


