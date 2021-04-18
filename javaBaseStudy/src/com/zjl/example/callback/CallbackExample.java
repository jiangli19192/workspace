package com.zjl.example.callback;

/**
 * Java回调机制
 *
 * 观察者模式与回调机制的关系
 *
 * 观察者模式：在对象之间定义一对多的依赖，这样一来，当一个对象改变状态，依赖它的对象都会收到通知，并自动更新。
 *
 * 以java回调机制及其实现为例，在例1中可以将FooBar作为一个主题（被观察者），ICallback的实现对象作为观察者，
 * 当FooBar调用setCallback时，通知ICallback的postExec()方法改变状态，当然这是一对一的依赖。
 * @author zjl
 */
public class CallbackExample {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar();
        fooBar.setCallback(new ICallback() {
        	@Override
            public void postExec() {
                System.out.println("在CallbackExample类中实现但不能被CallbackExample的对象调用，而由FooBar对象调用");
            }
        });
    }
}

interface ICallback {
    /**
     * 需要回调的方法
     */
    void postExec();
}

class FooBar {
    private ICallback callback;

    public void setCallback(ICallback callback) {
        this.callback = callback;
        doSth();
    }

    public void doSth() {
        callback.postExec();
    }
}