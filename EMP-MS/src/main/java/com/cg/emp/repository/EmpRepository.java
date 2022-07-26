package com.cg.emp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.emp.model.EmpModel;

public interface EmpRepository extends MongoRepository<EmpModel, String> {

}
