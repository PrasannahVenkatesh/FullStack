package com.fullstack.service;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullstack.pojo.Employee;
import com.fullstack.repository.FullStackRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
@Transactional
public class FullStackService {
	
	@Autowired
	FullStackRepository fullStackRepository;
	
	// traditional method to connect mongodb
	private MongoCollection<Document> getConnection() {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		mongoClient.listDatabaseNames().forEach(databaseName -> {
			System.out.println("Database -> " + databaseName);
		});
		
		MongoDatabase mongoDatabase = mongoClient.getDatabase("local");
		mongoDatabase.listCollectionNames().forEach(collectionName -> {
			System.out.println("Collection -> " + collectionName);
		});

		return mongoDatabase.getCollection("myDB");
	}
	
	public String createDocument() {
		Document document = new Document();
		document.put("name", "Prasannah");
		document.put("company", "Accenture");
		getConnection().insertOne(document);
		return "Inserted Successfully!";
	}
	
	public Document getDocument(){
		return getConnection().find().first();
	}
	// below methods uses repository to connect with mongodb and picks database name from application.properties file 
	// and collection name from pojo class
	public String createNew(Employee employee) {
		return fullStackRepository.save(employee).getId();
	}
	
	public List<Employee> getAll() {
		return fullStackRepository.findAll();
	}

}
