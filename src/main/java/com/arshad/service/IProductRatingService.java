package com.arshad.service;

import java.util.List;

import com.arshad.entity.ProductRating;

public interface IProductRatingService {

	Long createProductRating(ProductRating pr);
	boolean isCustomerRatedProduct(Long custId,Long prodId);
	List<ProductRating> getAllProductRatings(Long prodId);
}
