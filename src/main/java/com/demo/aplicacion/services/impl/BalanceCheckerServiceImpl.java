package com.demo.aplicacion.services.impl;

import com.demo.aplicacion.services.BalanceCheckerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
@Primary
@Slf4j
public class BalanceCheckerServiceImpl implements BalanceCheckerService {

    public boolean isBalanced(String s) {
        log.info("Input : " + s);
        if (s == null || s.isEmpty()) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
