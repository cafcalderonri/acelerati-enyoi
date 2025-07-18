package com.enyoi.orders.service;

import com.enyoi.orders.config.EnvsFacade;
import com.enyoi.orders.dto.ClientResponseDto;
import com.enyoi.orders.dto.CreateNewOrderCreatingNewClientDto;
import com.enyoi.orders.dto.GenerateNewOrderDto;
import com.enyoi.orders.dto.ProductResponseDto;
import com.enyoi.orders.dto.ProductShop;
import com.enyoi.orders.model.Order;
import com.enyoi.orders.model.ProductOrder;
import com.enyoi.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;
    private final EnvsFacade envsFacade;

    public Order createNewOrder(GenerateNewOrderDto dto){
        String clientId = getClientId(dto.getClientEmail());

        Order order = new Order();
        order.setClientId(clientId);

        List<ProductOrder> productOrderList = new ArrayList<>();
        for(ProductShop productShop: dto.getProductShopList()){
            ProductOrder productOrder = new ProductOrder();
            String productId = getProductId(productShop.getName());
            productOrder.setOrder(order);
            productOrder.setProductId(productId);
            productOrderList.add(productOrder);
        }

        order.setProductOrderList(productOrderList);

        return orderRepository.save(order);
    }

    private String getClientId(String clientEmail){
        String url = envsFacade.getClientHostEnv() + envsFacade.getClientPath() + clientEmail;
        ResponseEntity<ClientResponseDto> responseEntityDto = restTemplate.exchange(
                url, HttpMethod.GET, null, ClientResponseDto.class);
        return responseEntityDto.getBody().getId();
    }

    private String getProductId(String productName){
        String url = "http://localhost:8082/api/v1/product/" + productName;
        ResponseEntity<ProductResponseDto> responseEntity = restTemplate.exchange(
                url, HttpMethod.GET, null, ProductResponseDto.class);
        return responseEntity.getBody().getId();

    }












    public Order createNewOrderCreatingNewClient(CreateNewOrderCreatingNewClientDto dto){
        String url =  "http://localhost:8081/api/v1/client";

        HttpEntity<CreateNewOrderCreatingNewClientDto> request = new HttpEntity<>(dto);

        //LLAMO A MICROSERVICIO CLIENTES con la url, el verbo post, el contenido request, y esperando una respuesta ClientResponseDto
        ResponseEntity<ClientResponseDto> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, request, ClientResponseDto.class);

        ClientResponseDto bodyResponse = responseEntity.getBody();
        Order order = new Order();
        order.setClientId(bodyResponse.getId());
        return orderRepository.save(order);
    }




    //RestTemplate.exchange()
    //1. ¿Cuál es su URL? --> "http://localhost:8081/api/v1/client"
    //2. Cuál es el verbo? --> HttpMethod.POST
    //3. ¿Cuál es el contenido que va a enviar? --> Entidad de (nuevo cliente)
    //3. ¿Cuáles son los headers que vas a enviar? --> lo genrico
    //4. ¿Cuál es la respuesta esperada? --> CLientResponseDto.class


}
