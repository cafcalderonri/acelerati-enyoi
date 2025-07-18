package com.enyoi.products.controller;

import com.enyoi.products.dto.SaveNewProductDto;
import com.enyoi.products.dto.UpdateProductDto;
import com.enyoi.products.model.Product;
import com.enyoi.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> saveNewProduct(@RequestBody SaveNewProductDto dto){
        Product response = productService.saveNewProduct(dto.getName());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name){
        Product response = productService.getProductByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateStock(@PathVariable("id") String id,
                                               @RequestBody UpdateProductDto dto){
        Product response = productService.updateStock(id, dto.getQuantitySold());
        return ResponseEntity.ok(response);
    }


}
