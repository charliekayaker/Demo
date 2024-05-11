package com.demo.aplicacion.services;

import org.springframework.stereotype.Service;

@Service
public interface BalanceCheckerService {
    public boolean isBalanced(String s);
}
