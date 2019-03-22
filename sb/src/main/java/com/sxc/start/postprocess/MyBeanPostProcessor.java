package com.sxc.start.postprocess;

import org.springframework.beans.factory.config.BeanPostProcessor;
@org.springframework.stereotype.Component
public class MyBeanPostProcessor implements BeanPostProcessor{

    @Override
    public java.lang.Object postProcessAfterInitialization(java.lang.Object bean, java.lang.String beanName)
            throws org.springframework.beans.BeansException {
        // TODO Auto-generated method stub
        return org.springframework.beans.factory.config.BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
    
    
    @Override
    public java.lang.Object postProcessBeforeInitialization(java.lang.Object bean, java.lang.String beanName)
            throws org.springframework.beans.BeansException {
        // TODO Auto-generated method stub
        return org.springframework.beans.factory.config.BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
