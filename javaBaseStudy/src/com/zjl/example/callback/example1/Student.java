package com.zjl.example.callback.example1;

/**
 * 学生接口，原文出处http://www.cnblogs.com/xrq730/p/6424471.html
 * 学生当然是解决问题，但是接收一个Callback参数，这样学生就知道解决完毕问题向谁报告
 */
public interface Student {

    /**
     * 解决问题
     * @param callback
     */
    void resolveQuestion(Callback callback, String question);
}
