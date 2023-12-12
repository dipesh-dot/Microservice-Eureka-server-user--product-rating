package com.productservice.controller;

import com.productservice.entity.Product;
import com.productservice.generic.CustomResponseMessage;
import com.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

@PostMapping("/save")
private ResponseEntity<CustomResponseMessage>save (@RequestBody Product product){
    return getGlobalResponse(HttpStatus.CREATED,productService.CreateProduct(product),"Product created sucessfully");
}

@GetMapping ("/get-all")
private ResponseEntity<CustomResponseMessage>getAll (){
    return getGlobalResponse(HttpStatus.OK,productService.getAll(),"Here is List of Product sucessfully");
}




    private ResponseEntity<CustomResponseMessage> getGlobalResponse(HttpStatus status, Object data ,String message) {
        return ResponseEntity.ok().body(CustomResponseMessage.builder().status(status).data(data).message(message).build());
    }
}
