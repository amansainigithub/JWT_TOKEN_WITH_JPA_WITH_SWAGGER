package com.test.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	@Bean
	public Docket newsApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.any())
	            .paths(PathSelectors.any())
	            .build()
	            .securitySchemes(Lists.newArrayList(apiKey()))
	            .securityContexts(Lists.newArrayList(securityContext()))
	            .apiInfo(apiInfo());
	}
	
  private ApiInfo apiInfo(){
  return new ApiInfo(
          "Spring Boot Blog REST APIs",
          "Spring Boot Blog REST API Documentation",
          "1",
          "Terms of service",
          new Contact("AMAN SAINI", "http://pixcarry.com", "pixcarry@gmail.com"),
          "License of API",
          "API license URL",Collections.emptyList()
  );
}

	@Bean
	SecurityContext securityContext() {
	    return SecurityContext.builder()
	            .securityReferences(defaultAuth())
	            .forPaths(PathSelectors.any())
	            .build();
	}

	List<SecurityReference> defaultAuth() {
	    AuthorizationScope authorizationScope
	            = new AuthorizationScope("global", "accessEverything");
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	    authorizationScopes[0] = authorizationScope;
	    return Lists.newArrayList(
	            new SecurityReference("JWT", authorizationScopes));
	}

	private ApiKey apiKey() {
	    return new ApiKey("JWT", "Authorization", "header");
	}
	
	
	
	
//	/* Contact Info */
//	private static final String CONTACT_NAME = "pixcarry";
//	private static final String WEBSITE = "http://pixcarry.com";
//	private static final String EMAIL_ID = "demo@gmail.com";
//
//	/* API Info */
//	private static final String TITLE = "pixcarry";
//	private static final String DESCRIPTION = "API Documentation for PhyCorp Rest Services";
//	private static final String VERSION = "v1";
//	private static final String TERMS_OF_SERVICE_URL = "Terms of Serivces";
//	private static final Contact CONTACT = new Contact(CONTACT_NAME, WEBSITE, EMAIL_ID);
//	private static final String LICENSE = "demo";
//	private static final String LICENSE_URL = "dmeo";
//	private static final Set<String> DEFAULT_PRODUCER_CONSUMER = new HashSet(Arrays.asList("application/json"));

//	@Bean
//	public Docket dashboardApi() {
//		ParameterBuilder parameterBuilder = new ParameterBuilder();
//		parameterBuilder.name("Authorization").modelRef(new ModelRef("string")).parameterType("header").required(false)
//				.build();
//		List<Parameter> aParameters = new ArrayList<>();
//		aParameters.add(parameterBuilder.build());
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.test")).paths(PathSelectors.any())
//				.build().pathMapping("").globalOperationParameters((aParameters)).apiInfo(new ApiInfo(TITLE, DESCRIPTION, VERSION, TERMS_OF_SERVICE_URL, CONTACT, LICENSE,
//						LICENSE_URL, Collections.emptyList())).consumes(DEFAULT_PRODUCER_CONSUMER).produces(DEFAULT_PRODUCER_CONSUMER);
//	}
	
	
	
	
	
//
//    public static final String AUTHORIZATION_HEADER = "Authorization";
//
//    private ApiKey apiKey(){
//        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
//    }
//
//    private ApiInfo apiInfo(){
//        return new ApiInfo(
//                "Spring Boot Blog REST APIs",
//                "Spring Boot Blog REST API Documentation",
//                "1",
//                "Terms of service",
//                new Contact("AMAN SAINI", "http://pixcarry.com", "pixcarry@gmail.com"),
//                "License of API",
//                "API license URL",Collections.emptyList()
//        );
//    }
//
//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .securityContexts(Arrays.asList(securityContext()))
//                .securitySchemes(Arrays.asList(apiKey()))
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private SecurityContext securityContext(){
//        return SecurityContext.builder().securityReferences(defaultAuth()).build();
//    }
//
//    private List<SecurityReference> defaultAuth(){
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
//    }

//	
//	@Bean
//	public Docket postsApi() {
//		 return new Docket(DocumentationType.SWAGGER_2)
//	                .select()
//	                .apis(RequestHandlerSelectors.basePackage("com.test"))
//	                .paths(regex("/pis.*"))
//	               // .paths(PathSelectors.any()) // isko bhi use kar sakte hain
//	                .build()
//	                .apiInfo(apiInfo());
//	}

	
//
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder().title("SWAGGER API")
//				.description("Ishu Saini API for developers")
//				.termsOfServiceUrl("http://pixcarry.com")
//				.contact("https://pixcarry.com").license("PIXCARRY License")
//				.licenseUrl("pixcarry@gmail.com").version("1.0").build();
//	}
	
//	SWAGGER URL  :: http://localhost:8080/swagger-ui.html#

}

