package com.demo.infraestructura.adapter;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Product extends MongoRepository<Object, ObjectId> {

}
