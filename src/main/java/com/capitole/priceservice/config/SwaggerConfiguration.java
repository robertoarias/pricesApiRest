package com.capitole.priceservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	static final String TITLE = "Price REST API";
	static final String VERSION = "1.0.0";
	static final String DESCRIPTION = "Service para la obtencion de tarifa a aplicar en base a una fecha, un identificador de producto y un identificador de cadena dados";
			
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) 
                .useDefaultResponseMessages(false) 
                .select() 
                .apis(RequestHandlerSelectors.basePackage("com.capitole.priceservice")) 
                .paths(PathSelectors.any()) 
                .build();
	}
	

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(TITLE)
				.description(DESCRIPTION)
				.version(VERSION)
				.build();
	}

}