package com.demo.dominio.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.bson.types.ObjectId;

@Entity
@Data
public class Product {

    @Id
    private ObjectId id;
    private String name;
}
