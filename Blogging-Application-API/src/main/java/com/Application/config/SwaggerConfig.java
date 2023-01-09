package com.Application.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	public static final String AUTHORIZATION_HEADER="Authorization";
	
	private ApiKey apiKeys() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER ,"header");
	}
	
	private List<SecurityContext> securityContexts(){
		return Arrays.asList(SecurityContext.builder().securityReferences(sr()).build());
	}
	
	private List<SecurityReference> sr(){
		
		AuthorizationScope scope = new AuthorizationScope("global","access everything");
		return Arrays.asList(new SecurityReference("scope", new AuthorizationScope[] {scope}));
	}
	@Bean
	public Docket api() {
		
		
		
		

		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo())
				.securityContexts(securityContexts())
				.securitySchemes(Arrays.asList(apiKeys()))
				.select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	 

	private ApiInfo getInfo() {

		return new ApiInfo("Blogging Application",
				"This is a Blogging application api with some CURD operations and many more ..", "1.0",
				"Terms of Service", new Contact("Yogesh", "+91 9352269804", "yogesh000saini@gmail.com"),
				"License of APIS", "API license URL", Collections.emptyList());
	}
}
