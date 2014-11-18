package com.example.servletjspdemo.domain;

import java.util.UUID;

public class Wines 	{
		private String type = "";
		private String origin = ""; 
		private String[] strain;
		private String name = "";
		private int year;
		private String sweetness = "";
		private String alcohol = "";
		private String price;
		private Long uuid = UUID.randomUUID().getLeastSignificantBits();
	
	public Wines()
	{
		
		super();
		System.out.println(uuid);
	}

	public Wines(String type, String origin, String[] strain,
			String name, int year, String sweetness,
			String alcohol, String price)
	{
		super();
		this.type = type;
		this.origin = origin;
		this.strain = strain;
		this.name = name;
		this.year = year;
		this.sweetness = sweetness;
		this.alcohol = alcohol;
		this.price = price;
	}
	
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getOrigin() {
		return origin;
	}
	
	public void setStrain(String[] strain){
		this.strain = strain;
	}
	public String[] getStrain(){
		return strain;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	public int getYear(){
		return year;
	}
	
	public void setSweetness(String sweetness){
		this.sweetness = sweetness;
	}
	public String getSweetness(){
		return sweetness;
	}
	
	public void setAlcohol(String alcohol){
		this.alcohol = alcohol;
	}
	public String getAlcohol(){
		return alcohol;
	}
	
	
	public void setPrice(String price){
		this.price = price;
	}
	public String getPrice(){
		return price;
	}
	
	public long getId(){
		return uuid;
	}
	public void setId(Long uuid) {
		this.uuid = uuid;
	}
	
	public String getStringFromTable() {
		String out = "";
		if(strain != null){	
		for(int i=0; i<strain.length; i++){
				out += strain[i] + ", ";		
		}
		}
		else if (strain == null){
			out = "none selected";
		}
		return out;
	}
	
}