package com.cg.jwt.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.jwt.model.ERole;
import com.cg.jwt.model.Role;

public interface RoleRepository extends MongoRepository<Role, String>  {

	 Optional<Role> findByName(ERole name);
}
