package com.zjl.example.callback.example1;

/**
 * 定义一个具体的学生叫Ricky
 *
 * 一个名叫Ricky的同学解决老师提出的问题，原文出处http://www.cnblogs.com/xrq730/p/6424471.html
 */
public class Ricky implements Student {
    @Override
    public void resolveQuestion(Callback callback, String question) {
        // 模拟解决问题
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("线程出现异常了。");
        }

        System.out.println("Ricky:让我想一想，" + question);
        // 回调，告诉老师作业写了多久
        callback.tellAnswer(3);
    }
}
