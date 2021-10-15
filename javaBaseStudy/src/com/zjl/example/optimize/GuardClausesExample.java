package com.zjl.example.optimize;

/**
 * 原文链接:https://blog.csdn.net/Soumns_Kris/article/details/78390492
 * 卫语句例子
 * <p>
 * 在开发复杂的业务逻辑时避免不了出现大量的业务判断，这时就会出现if()…else if()……else{};这其中可能不止出现一个else if();
 * 可能出现3，4，5…多个else if()的结构，这样会造成什么问题呢？下面通过一段未经处理的逻辑看一下这样写的问题在哪。
 */
public class GuardClausesExample {
    /**
     * 这是一个type类型
     */
    private int type = 0;

    public static void main(String[] args) {
        GuardClausesExample example = new GuardClausesExample();
        long start = System.currentTimeMillis();
        example.getType();
        System.out.println("getType take time:" + (System.currentTimeMillis() - start));

        long start1 = System.currentTimeMillis();
        example.getTypeNew();
        System.out.println("getTypeNew take time:" + (System.currentTimeMillis() - start1));
    }

    /**
     * 这样所造成的问题十分明显,若此逻辑不是我自己写的我需看完整个方法才能了解这是一个怎样的业务。代码过于冗长，可读性及差。如何解决这种问题呢？
     * <p>
     * 使用设计模式state模式(状态模式)，根据不同的状态来处理不同的业务(此处不做详细解释)
     * 使用卫语句
     * <p>
     * 此方法根据type类型的不同处理不同的业务(此处作为测试代码简单带过)
     * *但是每次处理完业务后需在else语句做一个其他业务的处理
     */
    public void getType() {
        if (type == 0) {
            System.out.println("type=0");
        } else {
            if (type == 1) {
                System.out.println("type=1");
            } else {
                if (type == 2) {
                    System.out.println("type=2");
                } else {
                    //若在此处再次判断type的值,这个嵌套会更加进行
                    setType();
                }
            }
        }
    }


    /**
     * 如何使用卫语句呢?请看下面事例代码:
     * <p>
     * 当使用卫语句之后，代码的逻辑十分简单，可读性很高。基本一目了然。而且减少了冗长的语句嵌套。
     */
    public void getTypeNew() {
        /**
         *当type的值满足条件后，直接return掉，将这个方法终止。不再继续进行了。
         *若所有条件均不满足，则执行setType();这个最终else的业务处理
         */
        if (type == 0) {
            System.out.println("type=0");
            return;
        }
        if (type == 1) {
            System.out.println("type=1");
            return;
        }
        if (type == 2) {
            System.out.println("type=2");
            return;
        }
        setType();
    }

    public void setType() {
        System.out.println("setType");
    }
}
