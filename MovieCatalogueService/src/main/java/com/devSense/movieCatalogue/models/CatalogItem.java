package com.devSense.movieCatalogue.models;

public class CatalogItem {
	private String movieName;
	private String desc;
	private double ratings;
	
	
	@Override
	public String toString() {
		return "CatalogItem [movieName=" + movieName + ", desc=" + desc + ", ratings=" + ratings + "]";
	}

	public CatalogItem(String movieName, String desc, double ratings) {
		super();
		this.movieName = movieName;
		this.desc = desc;
		this.ratings = ratings;
	}
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	
	
}
