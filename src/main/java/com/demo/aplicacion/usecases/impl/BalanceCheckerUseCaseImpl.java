package com.demo.aplicacion.usecases.impl;

import com.demo.aplicacion.services.BalanceCheckerService;
import com.demo.aplicacion.usecases.BalanceCheckerUseCase;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BalanceCheckerUseCaseImpl implements BalanceCheckerUseCase {

    private BalanceCheckerService balanceCheckerService;

    public BalanceCheckerUseCaseImpl(BalanceCheckerService balanceCheckerService) {
        this.balanceCheckerService = balanceCheckerService;
    }

    @Override
    public boolean checkBalance(String s){
        return balanceCheckerService.isBalanced(s);
    }
}
