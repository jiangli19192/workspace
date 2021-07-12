package com.zjl.study.thread;

import java.util.concurrent.Callable;

/**
 * 有返回值的任务类
 */
public class MyCallable implements Callable<String> {
    private String value;

    public MyCallable(String value) {
        this.value = value;
    }

    @Override
    public String call() throws Exception {
        return value;
    }
}
