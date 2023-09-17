package com.arshad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arshad.entity.Product;
import com.arshad.service.IBrandService;
import com.arshad.service.ICategoryService;
import com.arshad.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService service;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IBrandService brandService;
	
	private void commonUi(Model model) {
		model.addAttribute("categories", categoryService.getCategoryIdAndName("ACTIVE"));
		model.addAttribute("brands", brandService.getBrandIdAndName());
	}
	
	//1. show Register page
	@GetMapping("/register")
	public String showRegister(Model model) {
		commonUi(model);
		return "ProductRegister";
	}
	
	//2. save product
	@PostMapping("/save")
	public String saveProduct(
			@ModelAttribute Product product,
			Model model
			) 
	{
		Long id  = service.saveProduct(product);
		String message = "Product '"+id+"' created!";
		model.addAttribute("message", message);
		commonUi(model);
		return "ProductRegister";
	}
	
	//3. list all products
	@GetMapping("/all")
	public String showAll(Model model) 
	{
		
		List<Product> list = service.getAllProducts();
		model.addAttribute("list", list);
		return "ProductData";
	}
	
	//4. delete product by id
	
	//5. update product data
	
	
}
