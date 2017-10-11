package com.sxc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@ServletComponentScan("com.sxc")
@SpringBootApplication()
@PropertySource("classpath:common.properties")
@ComponentScan(basePackages = { "com.sxc" })
public class ManagerApp {
    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(ManagerApp.class).web(true).run(args);
    }
    
    @Autowired
    Environment env;
    /**
     * 注册ServletRegistrationBean
     * @return
     */
    @Bean
    public ServletRegistrationBean registrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),env.getProperty("spring.datasource.druid.stat-view-servlet.url-pattern"));
        /** 初始化参数配置，initParams**/
        //白名单
        bean.addInitParameter("allow",env.getProperty("spring.datasource.druid.stat-view-servlet.allow"));
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
       // bean.addInitParameter("deny", "192.168.1.73");
        //登录查看信息的账号密码.
        bean.addInitParameter("loginUsername", env.getProperty("spring.datasource.druid.stat-view-servlet.login-username"));
        bean.addInitParameter("loginPassword",env.getProperty("spring.datasource.druid.stat-view-servlet.login-password"));
        //是否能够重置数据.
        bean.addInitParameter("resetEnable",env.getProperty("spring.datasource.druid.stat-view-servlet.reset-enable"));
        return bean;
    }

    /**
     * 注册FilterRegistrationBean
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        bean.addUrlPatterns(env.getProperty("spring.datasource.druid.web-stat-filter.url-pattern"));
        //添加不需要忽略的格式信息.
        bean.addInitParameter("exclusions",env.getProperty("spring.datasource.druid.web-stat-filter.exclusions"));
        return bean;
    }

}