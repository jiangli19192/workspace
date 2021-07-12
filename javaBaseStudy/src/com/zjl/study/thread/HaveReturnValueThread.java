package com.zjl.study.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * 第三种创建线程的方式
 *
 * 有返回值的线程
 *
 * 创建有返回值的任务必须实现Callable接口：MyCallable
 * ExecutorService、Callable<Class>、Future
 *
 */
public class HaveReturnValueThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int taskSize = 2;
        // 创建一个线程池
        ExecutorService pool = newFixedThreadPool(taskSize);

        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for(int i = 0; i < taskSize; i++) {
            Callable c = new MyCallable(i +" ");
            // 执行任务并获取Future对象
            Future f = pool.submit(c);

            list.add(f);
        }

        // 关闭线程池
        pool.shutdown();

        // 获取所有并发任务的运行结果
        for(Future f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println("线程返回结果，res: " + f.get().toString());
        }
    }
}
