package com.sxc.start;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

public class MyPropertySourceLoader implements PropertySourceLoader{
    //返回处理哪些配置文件的后缀
    @Override
    public String[] getFileExtensions() {
        return new String[]{".abc"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

  
 

}
