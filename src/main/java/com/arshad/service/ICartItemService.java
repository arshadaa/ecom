package com.arshad.service;

import java.util.List;

import com.arshad.entity.CartItem;

public interface ICartItemService {

	Long addCartItem(CartItem cartItem);
	void removeCartitem(Long cartItemId);
	
	List<CartItem> viewAllItems(Long custId);
	CartItem getOneCartItem(Long custId,Long prodId);
	void updateQty(Long cartItemId,Integer qty);
	int getCartItemsCount(Long custId);
	void deleteAllCartItems(List<CartItem> cartItems);
}
