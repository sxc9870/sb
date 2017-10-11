package com.sxc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@MapperScan("com.sxc.dao.mapper")
@PropertySource("classpath:common.properties")
@SpringBootApplication
@ComponentScan(basePackages = { "com.sxc" })
public class CoreApp {
    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(CoreApp.class).web(true).run(args);
    }
 
}