package com.sara.web.models;

public class Animal {
	
	private String name;
	private String bread;
	private int weight;
	
	public Animal(String name,String bread,int weight) {
		this.name = name;
		this.bread = bread;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBread() {
		return bread;
	}

	public void setBread(String bread) {
		this.bread = bread;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
