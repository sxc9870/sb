package com.sxc.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan("com.sxc")
@SpringBootApplication()
@ComponentScan(basePackages = { "com.sxc" })
public class ManagerApp {
    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(ManagerApp.class).web(true).run(args);
    }

    
}