package com.zjl.example.callback.test2;

import org.junit.Test;


/**
 * 代码中Server实例调用了setCallBack方法，传入的参数果然是Client实例，
 * 而后这个Client实例的receiveMessage方法被Server端的私有成员调用，这个机制是属于Java的多态里面的。
 * 而Server端的私有接口成员就类似于函数指针一样。
 * <p>
 * Server实例调用了sendMessage后传入了一个字符串，而在sendMessage方法中，这个字符串又交给了Client的receiveMessage方法。
 */
public class CallBackTest {

    @Test
    public void testCallback() {
        Server server = new Server();
        Client client = new Client();

        server.setCallBack(client);
        server.sendMessage("Server send Client a message.");
    }

    @Test
    public void testCallback_2() {
        Server server = new Server();

        CallBackInterface cbi = (message) -> System.out.println("Client receive a message: " + message);

        server.setCallBack(cbi);
        server.sendMessage("Server send Client a message 2.");
    }
}
