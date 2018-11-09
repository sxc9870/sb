package sb.sb;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.sxc")
public class MyMvcCOnfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver v = new InternalResourceViewResolver();
        return v;
    }
    
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return null;
    }
    
    @Bean
    public ServletListenerRegistrationBean<?> ser(){
        return null;
    }
    
    
    @Bean 
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        return null;
    }
    
    
    
    
}
