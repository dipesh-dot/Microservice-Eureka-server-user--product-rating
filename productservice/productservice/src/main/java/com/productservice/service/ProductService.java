package com.productservice.service;

import com.productservice.dto.ProductDto;
import com.productservice.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public ProductDto CreateProduct(Product product);
    public List<ProductDto> getAll();

}
