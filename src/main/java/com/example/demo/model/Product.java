package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
//import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// DBのidentity列を使用して、キーを自動採番。

	@NotBlank
	@Size(max = 40)
	private String name;
	
	@Range(max = 500000)
	private Long price;
	
	public String setPriceEn() {
		return price + "円";
	}
	
//	private MultipartFile image;
//	private byte[] image;

	@ManyToOne
	private Genre genre;
	// 多対１
}
