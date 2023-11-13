package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
class OpenApiConfig {

    @Value("${server.port}")
    private int port;

    @Bean
    public OpenAPI myOpenAPI() {
        Server localServer = new Server();
        localServer.setUrl("http://localhost:" + port + "/");
        localServer.setDescription("Server URL in Production environment");

        Info info = new Info()
                .title("Car Rental API")
                .version("1.0");

        return new OpenAPI().info(info).servers(List.of(localServer));
    }
}