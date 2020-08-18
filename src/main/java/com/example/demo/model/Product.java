package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
// データの入れ物 Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// DBのidentity列を使用して、キーを自動採番。
	private Long id;
	
	@NotBlank
	@Size(max = 40)
	private String name;
	
	@ManyToOne
	// 多対１
	private Genre genre;

}
