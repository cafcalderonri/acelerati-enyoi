package com.enyoi.orders.service;

import com.enyoi.orders.config.EnvsFacade;
import com.enyoi.orders.config.EnvsFacadeImpl;
import com.enyoi.orders.dto.ClientResponseDto;
import com.enyoi.orders.dto.GenerateNewOrderDto;
import com.enyoi.orders.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    RestTemplate restTemplate;

// ---> ESTO ES UN BEAN FICTICIO EN EL CUAL VAMOS A CONTROLAR TODAS SUS INTERACCIONES.
//SI YO NO LAS DEFINO, ENTONCES LA INTERACCIÓN ES UN NULO

    @Spy //--> ESTO ES UN BEAN "REAL" PERO PUEDO CONTROLARLE ALGUNAS DE SUS INTERACCIONES.
    EnvsFacade envsFacade = new EnvsFacadeImpl();

    @InjectMocks
    OrderService orderService;


    //any --> AnyString any(clase especifíca), eq("hola mundo")
    @Test
    void shouldCreateNewOrder(){
        //Arrange
        when(envsFacade.getClientHostEnv()).thenReturn("localhost:8081");

        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), eq(null),
                eq(ClientResponseDto.class))).thenReturn(getInstanceOfResponse());

        //Act
        orderService.createNewOrder(getDtoInstance());

        //Assert
        verify(orderRepository).save(any()); //VERIFICAR QUE ALOG SE HIZO
    }

    @Test
    void shouldThrowAnException(){
        //Arrange
        //when(envsFacade.getClientHostEnv()).thenThrow(new RuntimeException("ERROR"));

        //Act
        assertThrows(RuntimeException.class, () -> orderService.createNewOrder(getDtoInstance()));

        //Assert
        verifyNoInteractions(orderRepository);
    }

    private GenerateNewOrderDto getDtoInstance(){
        GenerateNewOrderDto dto = new GenerateNewOrderDto();
        dto.setClientEmail("prueba@mail.com");
        return dto;
    }

    private ResponseEntity<ClientResponseDto> getInstanceOfResponse(){
        ClientResponseDto dto = new ClientResponseDto();
        dto.setId("123");
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


}
