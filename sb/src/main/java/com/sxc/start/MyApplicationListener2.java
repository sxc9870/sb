package com.sxc.start;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
@org.springframework.stereotype.Component
public class MyApplicationListener2
        implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("2:"+ event.getClass());
    }

    

}
