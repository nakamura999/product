package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ProductController {
	private final ProductRepository repository;

	@GetMapping("/")
	public String showList(Model model) {
		model.addAttribute("products", repository.findAll());
		return "index";
	}

	@GetMapping("/add")
	public String addProduct(@ModelAttribute Product product) {
		return "form";
	}

	@PostMapping("/process")
	public String process(@Validated @ModelAttribute Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "form";
		}
		repository.save(product);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable Long id, Model model) {
		model.addAttribute("product", repository.findById(id));
		return "form";
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/";
	}
}
