package CyclicBarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CB {

	List<String> result = new ArrayList<>();
	static String[] dogs1 = {"boi", "clover", "harry"};
	static String[] dogs2 = {"aiko", "zoey", "biscuit"};
	final CyclicBarrier cycBarrier;
	
	class ProcessDogs implements Runnable{

		String [] dogs;
		public ProcessDogs(String [] d) {
			// TODO Auto-generated constructor stub
			this.dogs = d;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < dogs.length; i++) {
				String dogName = dogs[i];
				String newDogName = dogName.substring(0,1).toUpperCase() + dogName.substring(1);
				dogs[i] = newDogName;
				
			}
			
			try {
				cycBarrier.await();
			}
			catch(InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "is done.! ");
		}
		
	}
	
	public CB() {
		cycBarrier = new CyclicBarrier(2, ()->{
			for (int i = 0; i < dogs1.length; i++) {
				result.add(dogs1[i]);
			}
			for (int i = 0; i < dogs2.length; i++) {
				result.add(dogs2[i]);
			}
			System.out.println(Thread.currentThread().getName() + "Result : "+ result);
		});
		
		Thread t1 = new Thread(new ProcessDogs(dogs1));
		Thread t2 = new Thread(new ProcessDogs(dogs2));
		
		t1.start();
		t2.start();
		
		System.out.println("Main thread is done");
		
	}
	
	public static void main(String[] args) {
		CB cb = new CB();
	}
	
}
