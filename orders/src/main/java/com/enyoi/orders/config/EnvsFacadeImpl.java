package com.enyoi.orders.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvsFacadeImpl implements EnvsFacade {

    @Value("${app.envs.client.host}") //ESTO QUIERO QUE LO INYECTE COMO UNA VARIABLE DE ENTORNO
    private String host; //NO LO PODEMOS MOCKEAR


    @Override
    public String getClientHostEnv() {
        return host;
    }

    @Override
    public String getClientPath() {
        return "api/v1/client/";
    }
}
