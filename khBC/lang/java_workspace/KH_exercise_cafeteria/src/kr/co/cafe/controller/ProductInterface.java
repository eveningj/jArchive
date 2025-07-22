package kr.co.cafe.controller;


import java.util.Map;

import kr.co.cafe.model.vo.Product;

public interface ProductInterface {
    
	
void addProduct(Product product);               // CREATE
Map<String, Product> getAllProducts();         // READ ALL
void updateProduct(Product product);            // UPDATE
void deleteProduct(String name);                  // DELETE

}