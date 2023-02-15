package com.example.demo;

public class Greeting {
	
	//final is constant (meaning, must have value assigned to it and must be constant
	
	private final long id;
	private final String content;
	


	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}
	
	public long getId() {
		  return id;
	}

	public String getContent() {
		  return content;
	}
}
