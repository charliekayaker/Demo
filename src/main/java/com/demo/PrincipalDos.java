package com.demo;

import java.util.Stack;
/*
public class PrincipalDos {

    public static void main(String ...args){
        PrincipalDos principalDos = new PrincipalDos();
        System.out.println(principalDos.isBalanced("()"));
        System.out.println(principalDos.isBalanced("()()"));
        System.out.println(principalDos.isBalanced("()("));
        System.out.println(principalDos.isBalanced(")("));
    }

    public boolean isBalanced(String s){

        if(s == null || s.isEmpty()){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c== '('){
               stack.push(c);
            } else if (c == ')') {
                if(stack.isEmpty()){
                    return false;
                }else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
*/