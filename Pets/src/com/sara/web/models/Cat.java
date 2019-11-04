package com.sara.web.models;

public class Cat extends Animal implements Pet {
	
	public Cat(String name,String bread,int weight) {
		super(name,bread,weight);
	}
	
	public String showAffection(int weight){
		
		return "Your Persian cat, "+getName()+", looked at you with some affection. You think.";
	}
}
