package com.sonhaenono.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		 return new Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .consumes(getConsumeContentTypes())
            .produces(getProduceContentTypes())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.sonhaenono.dongcode.controller")
    			.or(RequestHandlerSelectors.basePackage("com.sonhaenono.member.controller"))
    		)
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("손해노노 API")
				.description("부동산 거래정보, 주변시세, 상권을 알아봐주는 손해노노입니다.")
				.version("0.1")
				.build();
	}
	
	private Set<String> getConsumeContentTypes() {
		Set<String> consumes = new HashSet<String>();
		consumes.add("application/json;charset=UTF-8");
		return consumes;
	}
	private Set<String> getProduceContentTypes() {
	    Set<String> produces = new HashSet<>();
	    produces.add("application/json;charset=UTF-8");
	    return produces;
	}
}
