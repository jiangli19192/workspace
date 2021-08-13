package com.zjl.example.callback.test2;

public class Client implements CallBackInterface {
    @Override
    public void receiveMessage(String message) {
        System.out.println("Client receive a message = " + message);
    }
}
