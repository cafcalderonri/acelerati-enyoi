package com.enyoi.catalog.repository;

import com.enyoi.catalog.entity.ProductStock;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ProductStockRepository extends R2dbcRepository<ProductStock, String> {

}
