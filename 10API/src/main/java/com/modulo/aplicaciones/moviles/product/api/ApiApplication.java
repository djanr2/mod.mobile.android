package com.modulo.aplicaciones.moviles.product.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.modulo.aplicaciones.moviles.product.api.persistence",
                                "com.modulo.aplicaciones.moviles.product.api.rest",
                                "com.modulo.aplicaciones.moviles.product.api.entity"})
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
