package com.zjl.example.callback.test2;

/**
 * Server端代码
 *
 * 可以看出来Server端有一个CallBackInterface私有成员，而在setCallBack方法中，我们给这个私有成员赋值了，而这个值可以想到应该是来自Client端的。
 *
 * 后面又有一个sendMessage方法，在这个方法中，调用了实例化后的私有成员的receiveMessage方法，
 * 显然这个receiveMessage方法是Client继承了CallBackInterface接口后继承下来的方法，
 * 因此之前setCallBack传进来的值应该是Client实例。
 */
public class Server {

    private CallBackInterface callBackInterface;

    public Server() {

    }

    public void setCallBack(CallBackInterface callBackInterface) {
        this.callBackInterface = callBackInterface;
    }

    public void sendMessage(String message) {
        callBackInterface.receiveMessage(message);
    }
}
