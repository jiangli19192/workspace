package com.zjl.example.callback.test2;

/**
 * https://blog.csdn.net/weixin_28957683/article/details/114412455
 *
 * 定义一个接口用于消息传递——CallBackInterface
 */
public interface CallBackInterface {

    /**
     * 接收消息
     * @param message
     */
    void receiveMessage(String message);
}