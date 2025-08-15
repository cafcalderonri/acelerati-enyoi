package com.enyoi.catalog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductStockDto {

    private String id;
    private String name;
    private String description;
    private Integer stock;

}
