package com.cg.loc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.loc.model.LocModel;

public interface LocRepository extends MongoRepository<LocModel, String> {

}
