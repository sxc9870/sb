package com.sxc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration  
@PropertySource("classpath:application.properties")  
@ImportResource({ "classpath:dubbo-consume.xml" })  
public class DubboConfig {  
  
}  