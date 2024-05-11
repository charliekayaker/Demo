package com.demo.aplicacion.usecases;

import com.demo.aplicacion.services.BalanceCheckerService;
import com.demo.aplicacion.services.impl.BalanceCheckerServiceImpl;

public class BalanceCheckerUseCase {

    private BalanceCheckerService balanceCheckerService;

    public BalanceCheckerUseCase(BalanceCheckerService balanceCheckerService) {
        this.balanceCheckerService = balanceCheckerService;
    }

    public boolean checkBalance(String input){
        return balanceCheckerService.isBalanced(input);
    }
}
