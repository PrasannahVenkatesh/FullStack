package com.fullstack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.pojo.Employee;

@Repository
public interface FullStackRepository extends MongoRepository<Employee, String>{

}
