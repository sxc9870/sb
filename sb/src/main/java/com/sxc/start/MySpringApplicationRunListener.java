package com.sxc.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

public class MySpringApplicationRunListener implements SpringApplicationRunListener, Ordered {
    public MySpringApplicationRunListener(SpringApplication application, String[] args) {

    }

    @Override
    public void starting() {
        System.out.println("startting");

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        // TODO Auto-generated method stub
        System.out.println("environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        // TODO Auto-generated method stub
        System.out.println("contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        // TODO Auto-generated method stub
        System.out.println("contextLoaded");
    }

    public void finished(ConfigurableApplicationContext context, Throwable exception) {
        // TODO Auto-generated method stub
        System.out.println("finished");
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        // TODO Auto-generated method stub

    }

}
