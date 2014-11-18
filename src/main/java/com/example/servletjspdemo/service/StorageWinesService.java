package com.example.servletjspdemo.service;
import com.example.servletjspdemo.domain.Wines;

import java.util.ArrayList;
import java.util.List;



public class StorageWinesService {

	private List<Wines> db = new ArrayList<Wines>();
	
	public void add(Wines wine){
		Wines newWine = new Wines(wine.getType(), wine.getOrigin(),
				wine.getStrain(), wine.getName(), wine.getYear(), wine.getSweetness(),
				wine.getAlcohol(), wine.getPrice());
		
		db.add(newWine);
	}
	
	public List<Wines> getAllWines(){
		return db;
	}
	
	public void delete(long uuid){
		int i=0;
		while(db.get(i).getId() != uuid)
			i++;
		if(db.get(i).getId() == uuid)
			db.remove(i);
	}				
	
	public void update(long uuid){
		int i=0;
		while(db.get(i).getId() != uuid)
			i++;
		if(db.get(i).getId() == uuid)
			db.get(i);
	}
	
	public void setUpdate(Wines wine, long uuid){
		int i=0;
		while(db.get(i).getId() != uuid)
			i++;
		if(db.get(i).getId() == uuid){
			db.set(i, wine);
		}
	}
	
}
