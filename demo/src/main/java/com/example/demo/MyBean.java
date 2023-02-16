package com.example.demo;

public class MyBean {
	
	private String name;
	
	public MyBean(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
