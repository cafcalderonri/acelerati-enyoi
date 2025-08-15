package com.enyoi.products.service;

import com.enyoi.products.entity.Product;
import com.enyoi.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Mono<Product> saveProduct(Product product){
        return productRepository.save(product);
    }

    public Flux<Product> getProductsById(Flux<String> idFlux){
        return productRepository.findAllById(idFlux);
    }

    public Mono<Product> getProductById(String id){
        return productRepository.findById(id);
    }




}
