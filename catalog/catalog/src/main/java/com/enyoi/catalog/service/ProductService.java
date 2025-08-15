package com.enyoi.catalog.service;

import com.enyoi.catalog.dto.ProductInfoDto;
import com.enyoi.catalog.dto.ProductStockDto;
import com.enyoi.catalog.entity.ProductStock;
import com.enyoi.catalog.repository.ProductStockRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private ProductStockRepository productStockRepository;
    private WebClient webClient = WebClient.create("http://localhost:8080"); //ESTO ES UN CLIENTE WEB que no es bloqueante


    public Flux<ProductStockDto> getCatalogWithInfo(){
        return productStockRepository.findAll()
                .filter(productStock -> productStock.getStock() >= 0)
                .flatMap( productStock -> {
                        Mono<ProductInfoDto> productInfoDtoMono = webClient.get().uri("/api/v1/product/" + productStock.getProductId())
                                .retrieve().bodyToMono(ProductInfoDto.class);
                        return productInfoDtoMono.flatMapMany(productInfoDto ->
                            Flux.just(mapResponse(productInfoDto, productStock))
                        );
                });
    }

    private ProductStockDto mapResponse(ProductInfoDto productInfoDto, ProductStock productStock){
        ProductStockDto dtoResponse = new ProductStockDto();
        dtoResponse.setId(productInfoDto.getId());
        dtoResponse.setName(productInfoDto.getName());
        dtoResponse.setDescription(productInfoDto.getDescription());
        dtoResponse.setStock(productStock.getStock());
        return dtoResponse;
    }





}
