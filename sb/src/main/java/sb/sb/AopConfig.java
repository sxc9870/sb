package sb.sb;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sxc.aop.BeanAopAdvice;

@Configuration
public class AopConfig {

    
//    @Bean
//    public  Pointcut myPointCut(){
//        AspectJExpressionPointcut pointcuts=new AspectJExpressionPointcut();
//        pointcuts.setExpression("* com.sxc.aop.*.do(..)");
//        return pointcuts;
//    }
    
    
    @Bean
    public  Advisor myAdvisor(BeanAopAdvice b){
        AspectJExpressionPointcutAdvisor a=new  AspectJExpressionPointcutAdvisor();
        a.setAdvice(b);
        a.setExpression("execution(* com.sxc.aop..*.*(..))");
        return a;
        
    }
    
}
