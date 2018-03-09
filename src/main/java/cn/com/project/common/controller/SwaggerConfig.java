package cn.com.project.common.controller;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.any;

/**
 * Created by lpc on 2018-03-06.
 */
@Configuration
@EnableSwagger2
@ComponentScan("cn.com.project.common")
public class SwaggerConfig {
    @Bean
    public Docket swaggerSpringMvcPlugin() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("common")
                .select()
                .apis(any())
                .paths(paths())
                .build()
                .apiInfo(apiInfo());
        docket.host("localhost");
        docket.pathMapping("common/");
        return docket;
    }

    private Predicate<String> paths() {
        return or(
                regex("/api.*"),
                regex("/common.*")
        );
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("lpc", "", "lwl243098053@163.com");
        ApiInfo apiInfo = new ApiInfo(
                "公共模块api",
                "公共模块api",
                "v0.0.1",
                "",
                contact,
                "",
                "");
        return apiInfo;
    }
}

