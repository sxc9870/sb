package com.sxc.tx;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TxTest2 {

    @org.springframework.beans.factory.annotation.Autowired
    private com.sxc.mapper.TestMapper testMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public void doSigleBook() {

        testMapper.inser();
        doSigleBook2();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void doSigleBook2() {
        testMapper.insert();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void doSigleBook3() {
        testMapper.Select();
        testMapper.insert();
    }

}
