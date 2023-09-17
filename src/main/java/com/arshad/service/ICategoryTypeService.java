package com.arshad.service;

import java.util.List;
import java.util.Map;

import com.arshad.entity.CategoryType;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
public interface ICategoryTypeService {
	Long saveCategoryType(CategoryType categorytype);
	void updateCategoryType(CategoryType categorytype);
	void deleteCategoryType(Long id);
	CategoryType getOneCategoryType(Long id);
	List<CategoryType> getAllCategoryTypes();
	
	Map<Integer,String> getCategoryTypeIdAndName();
	long totalCategoryTypes();
}
