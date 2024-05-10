package com.demo.infraestructure.adapter;

import com.demo.dominio.entities.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryTest extends MongoRepository<Product, ObjectId> {

}
