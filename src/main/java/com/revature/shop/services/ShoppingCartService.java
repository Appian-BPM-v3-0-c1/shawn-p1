package com.revature.shop.services;

import com.revature.shop.daos.ShoppingCartDAO;

public class ShoppingCartService {
    public ShoppingCartDAO getShoppingCartDAO() {
        return shoppingCartDAO;
    }

    private final ShoppingCartDAO shoppingCartDAO;

    public ShoppingCartService(ShoppingCartDAO shoppingCartDAO) {
        this.shoppingCartDAO = shoppingCartDAO;
    }


}
