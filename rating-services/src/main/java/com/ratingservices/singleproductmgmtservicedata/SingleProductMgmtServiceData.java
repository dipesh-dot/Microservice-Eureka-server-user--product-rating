package com.ratingservices.singleproductmgmtservicedata;

import com.ratingservices.productproxy.ProductProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SingleProductMgmtServiceData {

    private final ProductProxy productProxy;

    public  String getSingleProductById(Long id){
        return productProxy.getProductName(id);
    }
}
