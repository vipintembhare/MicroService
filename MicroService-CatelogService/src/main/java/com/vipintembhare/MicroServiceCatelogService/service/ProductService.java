package com.vipintembhare.MicroServiceCatelogService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipintembhare.MicroServiceCatelogService.model.Product;
import com.vipintembhare.MicroServiceCatelogService.model.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	 
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
 
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
 
    public Optional<Product> findProductByCode(String code) {
        return productRepository.findByCode(code);
    }
}
