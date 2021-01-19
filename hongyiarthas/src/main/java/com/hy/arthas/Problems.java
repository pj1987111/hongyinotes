package com.hy.arthas;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  \* Created with IntelliJ IDEA.
 *  \* User: hongyi.zhou
 *  \* Date: 2021-01-18
 *  \* Time: 14:01
 *  \* Description: 
 *  \
 */
@Slf4j
public class Problems {

    private static int CPU_THREADS = 10;
    private static ExecutorService executorService = Executors.newFixedThreadPool(CPU_THREADS);

    public static void start() {
        // 模拟 CPU 过高
        cpu();
        // 模拟线程阻塞
        thread();
        // 模拟线程死锁
        deadThread();
    }

    /**
     * 模拟cpu高损耗
     */
    private static void cpu() {
        for (int i = 0; i < CPU_THREADS; i++) {
            executorService.submit(new Thread(() -> {
                while (true) {
                    cpurun();
                }
            }));
        }
    }

    /**
     * 只有完整退出的方法才可以被热更新
     */
    private static void cpurun() {
        log.info("cpu start");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 模拟线程阻塞,向已经满了的线程池提交线程
     */
    private static void thread() {
        // 添加到线程
        executorService.submit(new Thread(() -> {
            while (true) {
                log.debug("thread start");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
    }

    /**
     * 死锁
     */
    private static void deadThread() {
        Object resourceA = new Object();
        Object resourceB = new Object();
        Thread threadA = new Thread(() -> {
            synchronized (resourceA) {
                log.info(Thread.currentThread() + " get ResourceA");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info(Thread.currentThread() + "waiting get resourceB");
                synchronized (resourceB) {
                    log.info(Thread.currentThread() + " get resourceB");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (resourceB) {
                log.info(Thread.currentThread() + " get ResourceB");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info(Thread.currentThread() + "waiting get resourceA");
                synchronized (resourceA) {
                    log.info(Thread.currentThread() + " get resourceA");
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
