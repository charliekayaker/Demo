package com.demo.infraestructure.inbound.controllers;

import com.demo.aplicacion.usecases.BalanceCheckerUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    private BalanceCheckerUseCase balanceCheckerUseCase;

    public ValidationController(BalanceCheckerUseCase balanceCheckerUseCase) {
        this.balanceCheckerUseCase = balanceCheckerUseCase;
    }

    @PostMapping("/balance")
    public ResponseEntity<Boolean> balanceVerification(@RequestBody String input) {
        boolean result = balanceCheckerUseCase.checkBalance(input);
        return ResponseEntity.ok(result);
    }
}
