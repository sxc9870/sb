package com.sxc.controller;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sxc.api.ITest;
import com.sxc.base.BaseController;

@Controller
public class SampleController  extends BaseController{

    
    @Reference  
    private ITest i;
    
    
    
    @RequestMapping("/hello")  
    public ModelAndView  hello(Map<String,Object> map){  
        PageBean p=new PageBean();
        p.addObject("name",    i.addTest());
        return  getView("hello", p);  
    }  
    
    @RequestMapping("/hello2")  
    public ModelAndView  hello2(Map<String,Object> map){  
        PageBean p=new PageBean();
        p.addObject("name",    i.test());
        return  getView("hello", p);  
    }  
}