package com.demo.infraestructure.inbound.controllers;

import com.demo.aplicacion.usecases.BalanceCheckerUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    private BalanceCheckerUseCase balanceCheckerUseCase;

    @PostMapping("/balance")
    public boolean balanceVerification(String input) {
        return balanceCheckerUseCase.checkBalance(input);
    }
}
