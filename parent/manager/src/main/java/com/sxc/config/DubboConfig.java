package com.sxc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration  
@ImportResource({ "classpath:dubbo-consume.xml" })  
public class DubboConfig {  
  
}  