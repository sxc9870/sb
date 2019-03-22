package com.sxc.start;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

public class InitClasse implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered{

    public InitClasse() {

        System.out.println("InitClasse");
    }
 
    @Override
    public int getOrder() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // TODO Auto-generated method stub
        
    }
}
