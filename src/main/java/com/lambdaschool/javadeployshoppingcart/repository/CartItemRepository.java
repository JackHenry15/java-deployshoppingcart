package com.lambdaschool.javadeployshoppingcart.repository;

import com.lambdaschool.javadeployshoppingcart.models.CartItem;
import com.lambdaschool.javadeployshoppingcart.models.CartItemId;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, CartItemId>
{
}
