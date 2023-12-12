package com.ratingservices.controller;

import com.ratingservices.singleproductmgmtservicedata.SingleProductMgmtServiceData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rc1")
public class RatingController1 {
    private final SingleProductMgmtServiceData singleProductMgmtServiceData;

    public RatingController1(SingleProductMgmtServiceData singleProductMgmtServiceData) {
        this.singleProductMgmtServiceData = singleProductMgmtServiceData;
    }


    @GetMapping("/{id}")
    ResponseEntity<String>getProductNameById(@PathVariable Long id){
        return ResponseEntity.ok().body(singleProductMgmtServiceData.getSingleProductById(id));
    }
}
