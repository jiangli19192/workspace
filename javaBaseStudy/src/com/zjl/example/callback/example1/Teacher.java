package com.zjl.example.callback.example1;

/**
 * 老师对象，原文出处http://www.cnblogs.com/xrq730/p/6424471.html
 */
public class Teacher implements Callback {
    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    /**
     * 问问题方法askQuestion()，即向学生问问题
     */
    public void askQuestion() {
        String question = "1 + 2 = ?";
        System.out.println("老师：我开始问问题了。我的问题是" + question);
        student.resolveQuestion(this, question);
    }

    /**
     * 回调接口tellAnswer(int answer)，即学生回答完毕问题之后，老师要做的事情
     * @param answer
     */
    @Override
    public void tellAnswer(int answer) {
        System.out.println("老师：知道了，你的答案是" + answer);
        System.out.println("老师：问题回答正确。");
    }
}
