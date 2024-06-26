package com.tobeto.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Data
@ToString(exclude = "shelfs")
@EqualsAndHashCode(exclude = "shelfs")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int minimum;
	private String image;
	@OneToMany(mappedBy = "product")
	private List<Shelf> shelfs;
}