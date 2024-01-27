package com.bookmarket.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun api(): OpenAPI =
        OpenAPI()
            .info(
                Info().title("Book Market")
                    .description("Api of Book Market")
                    .version("v1.0.0")
            )

}