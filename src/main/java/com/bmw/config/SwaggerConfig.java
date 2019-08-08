package com.bmw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/******************************************************************
 *
 *    Java Lib, Powered By Dalian IBM.
 *
 *    Copyright (c) 2001-2018 Dalian IBM Co.,Ltd
 *    http://www.ibm.com/
 *
 *    Package:     com.bmw.config
 *
 *    Filename:
 *
 *    Description: (用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2018
 *
 *    Company:     Dalian IBM Co.,Ltd
 *
 *    @author: liuqiang
 *
 *    @version: 1.0.0
 *
 *    Create at:   2019-08-08 15:10
 *
 *    Revision:
 *
 *    2019-08-08 15:10
 *        - first revision
 *
 *****************************************************************/
@Configuration
@EnableSwagger2
@Import({springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class})
public class SwaggerConfig {

    //是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
    @Value(value = "${swagger.enabled}")
    Boolean swaggerEnabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                // 是否开启
                .enable(swaggerEnabled).select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.bmw"))
                // 指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).build().pathMapping("/");
    }


    //设置api信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("BMW Stock service ：swagger2 API Document")
                .description("BMWPOC")
                // 作者信息
                .contact(new Contact("BMWPOC","",""))
                .version("1.0.0")
                .build();
    }

}
