package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class CollectionBean {
	
	//inject collection object here
	@Autowired
	private List<String> namelist;
	
	public void printNameList() {
		System.out.println(namelist);
	}
	
	// constructor injection here
	private Set<String> nameSet;
	
	public CollectionBean(Set<String> strings) {
		this.nameSet = strings;
	}
	
	public void printNameSet() {
		System.out.println(nameSet); 
	}
	
	//map with setter injection
	private Map<Integer, String> nameMap;
	
	@Autowired
	public void setNameMap(Map<Integer, String> nameMap) {
		this.nameMap = nameMap;
	}
	
	public void printNameMap() {
		System.out.println(nameMap); 
	}
	
	//inject list of MyBean
//	@Autowired
//	private List<MyBean> beanList;
	
	//Inject with qualifier
	@Autowired(required = false)
	@Qualifier("CollectionBean")
	private List<MyBean> beanList = new ArrayList<>();
	
	public void printBeanList( ) {
		System.out.println(beanList);
	}
	
	//inject a collection and set it to empty
	 @Value("${names.list:}#{T(java.util.Collections).emptyList()}")
	 private List<String> nameListWithDefaultValue;

	 public void printNameListWithDefaults() {
		 System.out.println(nameListWithDefaultValue);
	 }

}
