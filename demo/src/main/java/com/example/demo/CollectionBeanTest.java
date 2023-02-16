package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollectionBeanTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
	  ApplicationContext context = 
			  new AnnotationConfigApplicationContext(CollectionConfig.class);
	  
	// get the collection bean
	  CollectionBean collectionBean = 
			  context.getBean(CollectionBean.class);
	  collectionBean.printNameList();
	  
	  collectionBean.printNameList();
	  
	  collectionBean.printNameSet();
	  
	  collectionBean.printNameMap();
	  
	  collectionBean.printBeanList(); //will print 2 unless remove the Qualifier
	  
	  collectionBean.printNameListWithDefaults();
  }
}
