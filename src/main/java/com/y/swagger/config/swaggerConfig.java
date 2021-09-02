package com.y.swagger.config;

import com.y.swagger.controller.helloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Controller;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启swagger
public class swaggerConfig {


    //配置了swagger的Docket的Bean实例
    @Bean
    public Docket docket(Environment environment) {
        //设置要显示的swagger环境
        Profiles profiles= Profiles.of("dev","text");
        //通过environment.acceptsProfiles方法判断是否在设定的环境中
        boolean b = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //设置是否显示 swagger配置
                .enable(b)
                .groupName("yy")//配置分组
                .select()
                //RequestHandlerSelectors 配置要扫描接口的方式
                //any() 扫描所有
                //none() 不扫描
                //withClassAnnotation() 扫描类上的注解
                //withMethodAnnotation()扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.y.swagger.controller"))
                //过滤什么路径
                //.paths(PathSelectors.ant("/swagger/**"))
                .build();
    }

    public ApiInfo apiInfo() {
        Contact contact = new Contact("y", "http://baidu.com", "122853@qq.com");

        return new ApiInfo("yy的api文档",
                "这是文档声明",
                "1.0",
                "http://baidu.com",
                contact, "license", "licenseurl", new ArrayList<>());

    }

}
