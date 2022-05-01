package com.revature.shop.services;

import com.revature.shop.daos.ProductDAO;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }
}


