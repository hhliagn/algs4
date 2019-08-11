package com.itheima.service.impl;

import com.itheima.dao.TestMasterDao;
import com.itheima.dao.TestSlaveDao;
import com.itheima.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMasterDao testMasterDao;
    @Autowired
    private TestSlaveDao testSlaveDao;

    @Override
    @Transactional
    public String update() {
        testMasterDao.master();

        //模拟异常
        //int a=1/0;

        testSlaveDao.slave();

        return null;
    }


}
