package com.arshad.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arshad.entity.CategoryType;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
public interface CategoryTypeRepository extends JpaRepository<CategoryType, Long> {
	
	@Query("SELECT id, name FROM CategoryType")
	List<Object[]> getCategoryTypeIdAndName();
}
