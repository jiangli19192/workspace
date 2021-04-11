package com.zjl.study.designPattern.dip;

/**
 * @author zjl
 */
public class Client {
    public static void main(String[] args) {
        IMaterial book = new Book();
        IMaterial newsPaper = new NewsPaper();
        Mather mather = new Mather();
        mather.read(book);
        mather.read(newsPaper);
    }
}

/**
 * 抽象层
 */
interface IMaterial {
    /**
     * 返回读物里面的故事内容
     *
     * @return String
     */
    String getContent();
}

/**
 * Book和NewsPaper,都属于低层依赖抽象层
 */
class Book implements IMaterial {
    public String getContent() {
        return "书的故事很精彩";
    }
}

class NewsPaper implements IMaterial {
    public String getContent() {
        return "报纸的故事很精彩";
    }
}

/**
 * 高层依赖抽象层
 */
class Mather {
    public void read(IMaterial material) {
        System.out.println("妈妈开始讲故事");
        System.out.println(material.getContent());
    }
}
