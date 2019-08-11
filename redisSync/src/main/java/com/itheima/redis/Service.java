package com.itheima.redis;


import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 秒杀商品的业务类
 */
public class Service {
   private static JedisPool pool = null;
    private DistributedLock lock = new DistributedLock(pool);
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(200);
        // 设置最大空闲数
        config.setMaxIdle(8);
        // 设置最大等待时间
        config.setMaxWaitMillis(1000 * 100);
        // 在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例均是可用的
        config.setTestOnBorrow(true);
        pool = new JedisPool(config, "192.168.66.138", 6379, 3000);
    }


    int n = 500; //模拟商品总量

    public void seckill() {
        //获取锁
       String lockkey = lock.lockWithTimeout("itcast", 5000, 1000);

        System.out.println(--n);

        //释放锁
       lock.releaseLock("itcast",lockkey);

    }
}

