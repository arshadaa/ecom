package com.arshad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.arshad.entity.Brand;
import com.arshad.entity.Category;
import com.arshad.entity.CategoryType;
import com.arshad.service.IBrandService;
import com.arshad.service.ICategoryService;
import com.arshad.service.ICategoryTypeService;
import com.arshad.view.BrandsExportExcelView;
import com.arshad.view.CategoryTypesExportExcelView;
import com.arshad.view.categoriesExportExcelView;

@Controller
@RequestMapping("/emp")
public class EmployeeReports {

	@Autowired
	private IBrandService brandService;
	@Autowired
	private ICategoryTypeService categoryTypeService;
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("/reports")
	public String showReports(Model model)
	{
		long brandsCount = brandService.totalBrands();
		long categoryTypesCount = categoryTypeService.totalCategoryTypes();
		long categoriesCount = categoryService.totalCategoris();
	
		model.addAttribute("brands",brandsCount);
		model.addAttribute("categoryTypes",categoryTypesCount);
		model.addAttribute("categories",categoriesCount);
		
		return "EmployeeReportPage";
	}
	
	@GetMapping("/exportBrands")
	public ModelAndView exportBrands() {
		ModelAndView m = new ModelAndView();
		m.setView(new BrandsExportExcelView());
		List<Brand> list = brandService.getAllBrands();
		m.addObject("list", list);
		
		return m;
	}
	@GetMapping("/exportCategoryTypes")
	public ModelAndView exportCategoryTypes() {
		ModelAndView m = new ModelAndView();
		m.setView(new CategoryTypesExportExcelView());
		List<CategoryType> list = categoryTypeService.getAllCategoryTypes();
		m.addObject("list", list);
		
		return m;
	}
	
	@GetMapping("/exportcategories")
	public ModelAndView exportcategories() {
		ModelAndView m = new ModelAndView();
		m.setView(new categoriesExportExcelView());
		List<Category> list = categoryService.getAllCategorys();
		m.addObject("list", list);
		
		return m;
	}
	
}
