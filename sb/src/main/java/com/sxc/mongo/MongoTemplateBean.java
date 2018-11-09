package com.sxc.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoTemplateBean {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public MongoTemplateBean(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	
	public void insert(){
		
	//	mongoTemplate.insert(new Bean("sxc",1));
		
	}
	
	
	
	
	
}