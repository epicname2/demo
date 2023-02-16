package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class CollectionConfig {
	// inject collection bean
	
	@Bean
	public CollectionBean getCollectionBean(){
		return new CollectionBean(new HashSet<>(Arrays.asList("John", "Adam",
				"Harry")));
	}
//	@Bean
//	public CollectionBean getCollectionBean{
//		return new CollectionBean();
//	}
//	
	@Bean
	public List<String> nameList(){
		return Arrays.asList("John", "Adam", "Harry", null);
	}
	
	@Bean
	public Map<Integer, String> nameMap() {
		Map<Integer, String> nameMap = new HashMap<>();
		nameMap.put(1, "John");
		nameMap.put(2, "Adam");
		nameMap.put(3, "Harry");
		return nameMap;
	} 
	
	//add codes to initialize MyBean
	@Bean
	@Order(2) //put order so when we run, it will order the list as ordered
	@Qualifier("CollectionBean") //by using qualifier, we can force which one to be used.
	//remove qualifier from CollectionBean and here if don't need qualifier
	public MyBean getElement() { //we use qualifier just to select what to send
		return new MyBean("John");
	}
	
	@Bean
	@Order(3)
	@Qualifier("CollectionBean") //result will be that only John and Adam will be printout.
	public MyBean getAnotherElement() {
		return new MyBean("Adam");
	}
	
	@Bean
	@Order(1)
	public MyBean getOneMoreElement() {
		return new MyBean("Harry");
	} 
}
