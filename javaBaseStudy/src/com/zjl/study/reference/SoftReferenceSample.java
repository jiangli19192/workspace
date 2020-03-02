package com.zjl.study.reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class SoftReferenceSample {
    public static void main(String[] args) {
        // str是一个强引用
        String str = new String("HelloWorld");
        // 声明一个引用队列rq
        ReferenceQueue<String> rq = new ReferenceQueue<>();
        // 声明一个软引用,并且将sr指向str所指的对象,也就是"HelloWorld"
        WeakReference<String> sr = new WeakReference<String>(str);
        // 声明一个弱引用,并且将wr指向str所指的对象，并将他和引用队列绑定
        WeakReference<String> wr = new WeakReference<String>(str, rq);

        str = null;  // 将HelloWorld对象的强引用str制空
        sr = null;   // 将HelloWorld对象的软引用sr制空

        // 进行两次垃圾回收，wr引用大概率被回收
        System.gc();
        System.gc();

        // 如果wr被回收，此处会打印null
        System.out.println(wr.get());
        // 通过poll方法得到rq队列中的Reference对象
        WeakReference<String> tmp = (WeakReference) rq.poll();
        System.out.println(tmp);
    }
}