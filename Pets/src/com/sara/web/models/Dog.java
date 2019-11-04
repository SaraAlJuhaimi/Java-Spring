package com.sara.web.models;

public class Dog extends Animal implements Pet {
	
	public Dog(String name,String bread,int weight) {
		super(name,bread,weight);
	}
	
	public String showAffection(int weight){
		if(weight<30) {
			return this.getName()+" hopped into uour lap and cuddled you!.";
		}
		else
		{
			return this.getName()+" curlled up next to you!.";
		}
	}
}
