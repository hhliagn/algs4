package com.itheima.controller;

import com.itheima.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Controller
public class TestController{

    @Autowired
    private TestService testService;


    //MySQL的数据库引擎必须是InnoDB，否则无法回滚
    @Test
    public void test(){
        testService.update();
    }

}
