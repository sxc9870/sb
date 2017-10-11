package com.sxc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.sxc.api.ITest;
import com.sxc.dao.mapper.BorrowerMapper;
@Service(interfaceName="com.sxc.api.ITest")  //dubbo的注解
public class ITestImpl implements ITest {
    
    public ITestImpl() {
    System.out.println("testimpl");
    }
    @Autowired
    private BorrowerMapper userMapper;
    @Override
    public String test() {
        return ("NMB"+userMapper.select());
    }
    @Override
    public String addTest() {

        userMapper.select();
         return "";
    }

}
