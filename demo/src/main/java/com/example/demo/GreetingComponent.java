package com.example.demo;
import org.springframework.stereotype.Component;

@Component
public class GreetingComponent {
	
	//add a method to return a string message
	public String getMessage() {
		return "Hello from GreetingComponent";
	}

}
