package com.vojtechruzicka.springfoxexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)

public class SpringFoxConfig {
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vojtechruzicka"))
                .paths(PathSelectors.ant("/v2/**"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "SpringFox Demo Application",
                "This is an Demo Application using SWAGGER to document Spring Boot app using SpringFox",
                "1.0",
                "https://www.github.com/sleevezip",
                new Contact("Maurits", "https://www.github.com/sleevezip", "maurits.bruinsma@devoteam.com"),
                "LICENSE",
                "www.devoteam.com",
                Collections.emptyList()
        );
    }
}