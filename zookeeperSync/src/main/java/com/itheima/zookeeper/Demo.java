package com.itheima.zookeeper;

/**
 *
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
        DistributedLock lock = new DistributedLock("192.168.66.133:2181","test1");
        //创建节点，且获取锁
       lock.lock();

        //执行业务
        service.seckill();

        //释放锁
        lock.unlock();
    }
}
