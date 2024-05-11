package com.demo.aplicacion.services.impl;

import com.demo.aplicacion.services.BalanceCheckerService;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class BalanceCheckerServiceImpl implements BalanceCheckerService {

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
