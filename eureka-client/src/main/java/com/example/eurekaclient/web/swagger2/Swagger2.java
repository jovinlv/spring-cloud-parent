package com.example.eurekaclient.web.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Created by jovin on 2019/1/30 0030.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

  @Bean
  public Docket createRestApi(){
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        //为当前包路径
        .apis(RequestHandlerSelectors.basePackage("com.example.eurekaclient.web.controller"))
        .paths(PathSelectors.any())
        .build();
  }

  //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        //页面标题
        .title("Spring Boot 使用 Swagger2 构建RESTful API")
        //创建人
        .contact("jovin")
        //版本号
        .version("1.0")
        //描述
        .description("奋发图强")
        .build();
  }
}
