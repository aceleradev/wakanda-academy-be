package dev.wakandaacademy.api.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.wakandaacademy.api.domain.user.model.User;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket aceleraDevApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aceleradev.api"))
                .build()
                .ignoredParameterTypes(User.class).globalOperationParameters(
                        Arrays.asList(new ParameterBuilder().name("Authorization")
                                .description("Header para Token JWT")
                                .modelRef(new ModelRef("String"))
                                .parameterType("header")
                                .required(false)
                                .build()));
    }

}
