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

class NewsPaper {
    public String getContent() {
        return "报纸的故事很精彩";
    }
}

class Mather {
    public void read(Book book) {
        System.out.println("妈妈开始讲故事");
        System.out.println(book.getContent());
    }

    /**
     * 新增了NewsPaper类
     * 妈妈就增加一个读报纸的方法。
     * 扩展一个类，就修改妈妈这个类，这种实现违反了开闭原则。
     *
     * 出现此问题的原因：
     *      高层依赖低层，Mather类依赖于具体的书或报纸
     *
     * @param newsPaper
     */
    public void readNewsPaper(NewsPaper newsPaper) {
        System.out.println("妈妈开始讲故事");
        System.out.println(newsPaper.getContent());
    }
}
