package com.devSense.checkautowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = "prototype")
public class Alien {
	
	private int aId;
	private String aName;
	private String aTech;
	
	
	public Alien() {
		super();
		System.out.println("Object Created ...");
	}
	
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaTech() {
		return aTech;
	}
	public void setaTech(String aTech) {
		this.aTech = aTech;
	}
	
	public void show() {
		System.out.println("In the show!!");
		laptop.compile();
	}
	
	@Autowired
	private Laptop laptop;


	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
}
