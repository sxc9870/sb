package com.sxc.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

@org.springframework.stereotype.Component
public class BeanAopAdvice  implements MethodBeforeAdvice{

    public BeanAopAdvice() {
         System.out.println("");
    }
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("before");
    }
}
