package com.sxc.start.postprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
@org.springframework.stereotype.Component
public class MyBeanDefinitionRegistryPostProcessor  implements BeanDefinitionRegistryPostProcessor{

    public MyBeanDefinitionRegistryPostProcessor() {
        System.out.println("MyBeanDefinitionRegistryPostProcessor");
    }
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
     System.out.println("postProcessBeanFactory");
        
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("postProcessBeanDefinitionRegistry");
    }

}
