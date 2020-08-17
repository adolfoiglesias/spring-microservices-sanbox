package com.calarix.microservices.comment.model;

import java.util.List;

import lombok.Data;

@Data
public class Tour {

	public Long id;
	
	public String name;
	
	public double price;
	
	public List<Category> categories;
}
