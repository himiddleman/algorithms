package com.leetcode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试
 * https://www.cnblogs.com/dolphin0520/p/3932921.html
 */
class ThreadPoolTest {
    public static void main(String[] args) {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
//        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5));

        for (int i = 0; i < 16; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}


class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task " + taskNum);
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕");
    }
}