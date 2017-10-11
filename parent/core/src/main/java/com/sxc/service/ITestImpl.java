package com.sxc.service;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.sxc.api.ITest;
import com.sxc.dao.mapper.BorrowerMapper;
@Service   //dubbo的注解
public class ITestImpl implements ITest {
    
    public ITestImpl() {
    System.out.println("testimpl");
    }

    @Resource
    private BorrowerMapper userMapper;
    @Override
    public String test() {
        return ("NMB"+userMapper.select());
    }

}
