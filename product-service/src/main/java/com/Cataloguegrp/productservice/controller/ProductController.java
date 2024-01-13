package com.Cataloguegrp.productservice.controller;

import com.Cataloguegrp.productservice.dto.ProductRequest;
import com.Cataloguegrp.productservice.dto.ProductResponse;
import com.Cataloguegrp.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);

    }

    @GetMapping("getProduct")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts()
    {
        return productService.getAllProducts();
    }

}
