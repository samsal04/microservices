package com.apolis.entity;

import java.util.List;

public class ProductList {

    List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

  
    @Override
    public String toString() {
        return "ProductList [products=" + products + "]";
    }   
    
    
}
