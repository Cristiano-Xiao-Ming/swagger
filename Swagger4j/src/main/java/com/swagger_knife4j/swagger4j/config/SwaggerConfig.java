package com.swagger_knife4j.swagger4j.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi//该注解是Springfox-swagger框架提供的使用Swagger注解，该注解必须加
@EnableKnife4j//该注解是knife4j提供的增强注解,Ui提供了例如动态参数、参数过滤、接口排序等增强功能,如果你想使用这些增强功能就必须加该注解，否则可以不用加
@Configuration
public class SwaggerConfig {
/**
 * 接口构建器
 *
 * @return
 */
@Bean
public Docket docket() {
    return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo())
            //用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
            .apiInfo(apiInfo())
            //设置哪些接口暴露给Swagger展示
            .select()
             // (第一种方式)扫描所有有注解的api，用这种方式更灵活
            .apis( RequestHandlerSelectors.withMethodAnnotation( ApiOperation.class ) )

            // (第二种方式)扫描指定包中的swagger注解
            .apis(RequestHandlerSelectors.basePackage("com.swagger_knife4j.swagger4j.controller"))//构建API

            // (第三种方式)扫描所有
            .apis(RequestHandlerSelectors.any())
            .paths( PathSelectors.any() )

            .paths(PathSelectors.any())
            .build()
            .groupName("XimenesChen")
            .enable(true);
  }

   /**
     * 添加摘要信息
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     */
   private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("整合knife-4j，swaggerui基本注解")//标题
                    .description("整合knife-4j，swaggerui基本注解-描述")//描述
                    .contact(new Contact("cxm", "https://mp.csdn.net/mp_blog/manage/article?spm=1001.2014.3001.5114", "cristianoxm@qq.com"))
                    .version("V2.05")
                    .build();
   }
}
