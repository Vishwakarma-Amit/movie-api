package com.amit.movie.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Reviews")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review {
	
	@Id
	private ObjectId id;
	
	private String body;

	public Review(String body) {
		super();
		System.out.println("Review Constructor");
		this.body = body;
	}

}
