package com.vip.zn.fitness_system.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringBootVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConf
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/17 20:40
 */

@Configuration
@EnableSwagger2
public class SwaggerConf implements WebMvcConfigurer {

    private final SwaggerProperties swaggerProperties;

    public SwaggerConf(SwaggerProperties swaggerProperties) {
        this.swaggerProperties = swaggerProperties;
    }

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                //定义是否开始swagger，可通过变量关闭
                .enable(swaggerProperties.getEnable())
                //将API的元信息设置为包含在json ResourceListing响应中
                .apiInfo(apiInfo())
                //接口调试地址
                .host(swaggerProperties.getTryHost())
                //选择哪些接口作为swagger的doc发布
                .select()
                //为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.vip.zn.fitness_system"))
                //为有ApiOperation注的方法生成API文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * API 页面上半部分展示信息
     * @return
     */
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(swaggerProperties.getApplicationName())
                .description(swaggerProperties.getApplicationDescription())
                .version("Application Version: " + swaggerProperties.getApplicationVersion() + ", Spring Boot Version: " + SpringBootVersion.getVersion())
                .build();
    }


}
