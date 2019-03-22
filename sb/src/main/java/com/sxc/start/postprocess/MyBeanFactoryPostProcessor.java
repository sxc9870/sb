package com.sxc.start.postprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
@org.springframework.stereotype.Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

    
    
    public MyBeanFactoryPostProcessor() {
        System.out.println("MyBeanFactoryPostProcessor");
    }
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("postProcessBeanFactory");
    }

}
