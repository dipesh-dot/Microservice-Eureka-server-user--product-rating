package com.productservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto implements Serializable {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long rating;
}
