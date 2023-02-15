package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//putting the annotation for the restful controller
@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	//create a variable to store reference to component
	private GreetingComponent gc;
	
	//define a constructor
	//inject/initialize component in the constructor
	@Autowired //this annotation will do the injection for us
	public GreetingController(GreetingComponent gc) {
		this.gc = gc;
	}
	
	//define a method to call component's method
	@GetMapping("/testgc")
	public ResponseEntity<String> getMessage(){
		return ResponseEntity.ok(gc.getMessage());
	}
	
	// define the service's method
	@GetMapping("/greeting")
	public Greeting greeting
	(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), 
				String.format(template, name));
	}
}
