package com.wine.to.up.catalog.service.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class GeneralPurposesBeansConfig {

    /**
     * Model mapper bean
     */
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    /**
     * Object mapper bean
     */
    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public Docket catalogApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.catalogAPIInfo())
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .build();

    }

    private ApiInfo catalogAPIInfo() {
        return new ApiInfoBuilder()
                .title("Catalog API - build #1.0.1")
                .description("Enter the IDs in order to look for the content")
                .version("1.0.1")
                .build();
    }
}
