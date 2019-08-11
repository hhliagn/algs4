package com.itheima.dao.impl;

import com.itheima.dao.TestMasterDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class TestMasterDaoImpl implements TestMasterDao {
    @Resource(name = "masterJdbcTemplate")
    JdbcTemplate masterJdbcTemplate;

    @Override
    public String master() {
        masterJdbcTemplate.execute("update cst_customer set cust_name='CCCCCCCCCCCC' where cust_id=1");
        return "success";
    }
}
