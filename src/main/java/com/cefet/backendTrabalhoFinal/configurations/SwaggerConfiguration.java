package com.cefet.backendTrabalhoFinal.configurations;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Trabalho Final - API", version = "1.0", description = "Documentação do Trabalho Final project"))

@Configuration
public class SwaggerConfiguration {

}
