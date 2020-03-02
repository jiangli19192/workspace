package com.zjl.study.recursion;

import java.util.Stack;

public class Recursion {
	
	public static void main(String[] args){  
//        Factorial f = new Factorial(); 
		Recursion f = new Recursion(); 
		
        System.out.println(f.recursion(5));  
        System.out.println(f.loop(5));  
        System.out.println(f.iteration(5));  
    }  
  
    /** 
     * 递归求阶乘 
     */  
    public int recursion(int n){  
        if (n == 1) return 1;  
        return recursion(n-1) * n;  
    }  
  
    /** 
     * 循环求阶乘 
     */  
    public int loop(int n){  
        Stack<Integer> stack = new Stack<Integer>();  
        int result = 1;  
        stack.push(n);  
        while(!stack.isEmpty()){  
            n = stack.pop();  
            result *= n;  
            if (n > 1) stack.push(n-1);  
        }  
        return result;  
    }  
  
    /** 
     * 迭代求阶乘 
     */  
    public int iteration(int n){  
        int result = 1;  
        for(int i = 1; i <= n; i++){  
            result *= i;  
        }  
        return result;  
    }  
}
