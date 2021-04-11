package com.zjl.study.designPattern.dip;

public class Client {
    public static void main(String[] args) {
        Book book = new Book();
        Mather mather = new Mather();
        mather.read(book);
    }
}

class Book {
    public String getContent() {
        return "书的故事很精彩";
    }
}

class Mather {
    public void read(Book book) {
        System.out.println("妈妈开始讲故事");
        System.out.println(book.getContent());
    }
}
