package com.turkcell.SpringBootHibernateJPA.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class Config
{
	@Bean
	public OpenAPI springShopOpenAPI()
	{
		return new OpenAPI().info(new Info().title("OBS - Öğrenci Bilgi Sistemi").description("OBS application").version("V1.0").license(new License().name("Apache 2.0").url("localhost:8080/license"))).externalDocs(new ExternalDocumentation().description("OBS rest dökümantasyonu").url("localhost:8080/external"));
	}
}
