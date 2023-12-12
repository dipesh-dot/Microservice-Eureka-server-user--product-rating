package com.productservice.service.implementation;


import com.productservice.converter.DtoConverter;
import com.productservice.dto.ProductDto;
import com.productservice.entity.Product;
import com.productservice.repository.ProductRepository;
import com.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDto CreateProduct(Product product) {
        return DtoConverter.convert(productRepository.save(product));
    }

    @Override
    public List<ProductDto> getAll() {
       List<ProductDto> list = new ArrayList<>();
        for (Product product:productRepository.findAll()) {
            ProductDto convert = DtoConverter.convert(product);
            list.add(convert);
        }
        return list;

        //productRepository.findAll().stream().map(DtoConverter::convert).toList();
    }

    public String getNameById(Long id ){
        return productRepository.getNameById(id);
    }
}
