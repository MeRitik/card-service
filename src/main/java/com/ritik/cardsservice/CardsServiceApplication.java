package com.ritik.cardsservice;

import com.ritik.cardsservice.dto.CardContactInfoDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(CardContactInfoDTO.class)
@OpenAPIDefinition(
        info = @Info(
                title = "Cards Service API",
                description = "REST API Documentation for Cards Service",
                version = "v1",
                contact = @Contact(
                        name = "Ritik Ranjan",
                        email = "rranjan065.mca2023@nitrr.ac.in"
                )
        )
)
public class CardsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardsServiceApplication.class, args);
    }

}
