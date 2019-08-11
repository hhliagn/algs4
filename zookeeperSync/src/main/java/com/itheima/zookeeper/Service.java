package com.itheima.zookeeper;


/**
 * 秒杀商品的业务类
 */
public class Service {



    int n = 500; //模拟商品总量

    public void seckill() {
        System.out.println(--n);
    }
}

