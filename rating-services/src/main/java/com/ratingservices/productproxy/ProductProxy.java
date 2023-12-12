package com.ratingservices.productproxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name ="product-service",url = "http://localhost:9091")
public interface ProductProxy {

    @GetMapping("/product2/{id}")
    String getProductName(@PathVariable("id") Long id);
}
