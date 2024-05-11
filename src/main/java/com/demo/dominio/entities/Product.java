package com.demo.dominio.entities;

import jakarta.persistence.Id;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "PRODUCT")
public class Product {

    @Id
    private ObjectId id;
    private String name;
}
