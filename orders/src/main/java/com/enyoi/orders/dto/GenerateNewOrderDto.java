package com.enyoi.orders.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenerateNewOrderDto {

    @JsonProperty("client_email")
    private String clientEmail;

    private List<ProductShop> productShopList;



}
