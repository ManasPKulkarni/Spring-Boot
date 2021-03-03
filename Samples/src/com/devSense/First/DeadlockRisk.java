package com.devSense.First;

public class DeadlockRisk {

	private static class Resource{
		public int value;
	}
	
	private Resource a = new Resource();
	private Resource b = new Resource();
	
	public int read() {
		synchronized (a) {
			synchronized (b) {
				return a.value + b.value;
			}
		}
	}
	
	public void write(int x, int y) {
		synchronized (b) {
			synchronized (a) {
				a.value = x;
				b.value = y;
			}
		}
	}
}
