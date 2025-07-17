package com.enyoi.orders.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true) //CUALQUIER CAMPO QUE YO NO CONOZCA SIMPLEMENTE IGNORELO
public class ClientResponseDto {

    private String id;


}
