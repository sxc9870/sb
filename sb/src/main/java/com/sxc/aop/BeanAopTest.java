package com.sxc.aop;

@org.springframework.stereotype.Component
public class BeanAopTest  implements AopTestI  {

     
    
    public void doXXX(){
        System.out.println("doXXX");
    }

    @Override
    public void hello() {
        System.out.println("hello");
        
    }

  
}
