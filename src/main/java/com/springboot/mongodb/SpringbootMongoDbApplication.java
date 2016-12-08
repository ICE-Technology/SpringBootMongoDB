package com.springboot.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.springboot.config.document.SimpleDocument;

@SpringBootApplication
public class SpringbootMongoDbApplication implements CommandLineRunner{

	@Autowired
	MongoOperations mongoOperations;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongoDbApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// save
		SimpleDocument simpleDocument = new SimpleDocument("document_1", "this is description for document 1");
		mongoOperations.save(simpleDocument);
		System.out.println("Done!");
		
		// build mongo query
		/*Query query = new Query(Criteria.where("name").is("document_1"));
		
		// search operation
		SimpleDocument object = (SimpleDocument) mongoOperations.findOne(query, SimpleDocument.class);
		System.out.println(object.toString());
		System.out.println("Done!");*/
		
		//update operation
		/*Query query = new Query(Criteria.where("name").is("document_1"));
		mongoOperations.updateFirst(query, Update.update("description", "update description"), SimpleDocument.class);
		 
		System.out.println("Done!");*/
		
		// find all simple document in DB
		 /*List <SimpleDocument> objLst = mongoOperations.findAll(SimpleDocument.class);
		 System.out.println("Size of Object List = " + objLst.size());*/
		 
		 // delete a simple document in Db
		 /*Query query = new Query(Criteria.where("name").is("document_1"));
		 mongoOperations.remove(query, SimpleDocument.class);
		 System.out.println("Done!");*/
	}
}
