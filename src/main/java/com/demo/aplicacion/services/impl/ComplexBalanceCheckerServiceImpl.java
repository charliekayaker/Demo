package com.demo.aplicacion.services.impl;

import com.demo.aplicacion.services.BalanceCheckerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
@Slf4j
public class ComplexBalanceCheckerServiceImpl implements BalanceCheckerService {

    @Override
    public boolean isBalanced(String s) {
        log.info("Input : " + s);
        if (s == null || s.isEmpty()) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            log.info("analizando : " + s);
            log.info(" c: " + c);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char r = stack.pop();
                log.info("r : " + r);
                if (c == ')') {
                    if (r != '(') {
                        return false;
                    }

                } else if (c == ']') {
                    if (r != '[') {
                        return false;
                    }
                } else if (c == '}') {
                    if (r != '{') {
                        return false;
                    }

                }
            }
        }
        log.info("final");
        return stack.isEmpty();
    }
}
