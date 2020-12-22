package com.dsleandro.ecommerce.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = -7109299225386324228L;

	@Id
	@MongoId(value = FieldType.OBJECT_ID)
	private String id;

	private String name;

	private String description;

	private String brand;

	private Double price;

	private Integer amount;

	private String area;

}
