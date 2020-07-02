package com.willian.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.willian.springmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
