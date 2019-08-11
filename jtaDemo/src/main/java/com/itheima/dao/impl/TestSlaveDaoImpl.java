package com.itheima.dao.impl;

import com.itheima.dao.TestSlaveDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class TestSlaveDaoImpl implements TestSlaveDao {
    @Resource(name = "slaveJdbcTemplate")
    JdbcTemplate slaveJdbcTemplate;

    @Override
    public String slave() {
        slaveJdbcTemplate.execute("update user set username='CCCCCCCCCC' where id=1");
        return "success";
    }
}
