package com.sxc.start;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

public class MyApplicationContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("Initializer Create");
    }

    @Override
    public int getOrder() {
         
        return Ordered.LOWEST_PRECEDENCE;
    }

}
