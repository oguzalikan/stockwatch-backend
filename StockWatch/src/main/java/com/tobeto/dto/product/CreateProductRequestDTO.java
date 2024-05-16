package com.tobeto.dto.product;

import lombok.Data;

@Data
public class CreateProductRequestDTO {
	private int id;
	private String name;
	private int minimum;
	private String image;
}
