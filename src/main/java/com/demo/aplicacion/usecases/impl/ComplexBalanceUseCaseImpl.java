package com.demo.aplicacion.usecases.impl;

import com.demo.aplicacion.services.BalanceCheckerService;
import com.demo.aplicacion.usecases.ComplexBalancerUseCase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ComplexBalanceUseCaseImpl implements ComplexBalancerUseCase {

    private BalanceCheckerService balanceCheckerService;

    public ComplexBalanceUseCaseImpl(@Qualifier("complexBalanceCheckerServiceImpl")BalanceCheckerService balanceCheckerService) {
        this.balanceCheckerService = balanceCheckerService;
    }

    @Override
    public boolean checkBalance(String s) {
        return balanceCheckerService.isBalanced(s);
    }
}
