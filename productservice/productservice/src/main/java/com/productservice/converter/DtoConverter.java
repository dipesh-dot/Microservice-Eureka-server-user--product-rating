package com.productservice.converter;

import com.productservice.dto.ProductDto;

import com.productservice.entity.Product;

public class DtoConverter {
    public static ProductDto convert(Product entity) {
        if (entity == null)
            return null;

        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setRating(entity.getRating());
        return dto;
    }

  }


