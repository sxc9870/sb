package com.sxc.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ImportResource({ "classpath:dubbo-provider.xml" })
@AutoConfigureAfter(DataSource.class)
public class DubboConfig {

    
    public DubboConfig() {
        System.out.println("load dubbo");
    }
}