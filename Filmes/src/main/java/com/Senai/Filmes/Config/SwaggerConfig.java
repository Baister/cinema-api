package com.Senai.Filmes.Config;

<<<<<<< HEAD
=======

>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
<<<<<<< HEAD
    public OpenAPI openAPI() {
=======
    public OpenAPI openAPI(){
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
        return new OpenAPI()
                .info(new Info()
                        .title("Cinema API")
                        .description("API para gerenciamento de filmes, sessões e reservas")
                        .version("1.0.0"))
<<<<<<< HEAD
=======
                //Adiciona o botão "Authorize" no Swagger UI para inserir o token JWT
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .name("bearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}
