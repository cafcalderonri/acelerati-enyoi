package com.enyoi.orders.service;

import com.enyoi.orders.config.EnvsFacade;
import com.enyoi.orders.dto.ClientResponseDto;
import com.enyoi.orders.dto.CreateNewOrderCreatingNewClientDto;
import com.enyoi.orders.dto.GenerateNewOrderDto;
import com.enyoi.orders.model.Order;
import com.enyoi.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderService { //INYECTAR LAS DEPENDENCIAS

    private final OrderRepository orderRepository; //DEPENDENCIA
    private final RestTemplate restTemplate; //DEPENDENCIA
    private final EnvsFacade envsFacade; //DEPENDENCIA

    public Order createNewOrder(GenerateNewOrderDto dto){
        //GENERO LA URL
        String url = envsFacade.getClientHostEnv() + envsFacade.getClientPath() + dto.getClientEmail();

        //LLAMO AL MICROSERVICIO DE CLIENTES
        ResponseEntity<ClientResponseDto> responseEntityDto = restTemplate.exchange(
                url, HttpMethod.GET, null, ClientResponseDto.class);

        //HAGO EL RESTO DE MI LOGICA
        if(responseEntityDto.getStatusCode().is2xxSuccessful()){
            ClientResponseDto bodyResponse = responseEntityDto.getBody();
            Order order = new Order();
            order.setClientId(bodyResponse.getId());
            return orderRepository.save(order);
        }

        throw new RuntimeException("ERROR");
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
