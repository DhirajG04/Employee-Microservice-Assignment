package com.cg.dept.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.dept.model.DeptModel;

public interface DeptRepository extends MongoRepository<DeptModel, String> {

}
