package com.itheima.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis分布式锁
 */
public class Demo {

    public static void main(String[] args) {
        Service service = new Service();
        //模拟50个用户秒杀商品
        for (int i = 0; i < 50; i++) {
            ThreadA threadA = new ThreadA(service);
            threadA.start();
        }
    }
}

/**
 * 用户购买线程
 */
class ThreadA extends Thread {


    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.seckill();
    }
}