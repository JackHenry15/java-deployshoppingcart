package com.lambdaschool.javadeployshoppingcart.services;

import com.lambdaschool.javadeployshoppingcart.models.CartItem;

public interface CartItemService
{
    CartItem addToCart(
        long userid,
        long productid,
        String comment);

    CartItem removeFromCart(
        long userid,
        long productid,
        String comment);
}
