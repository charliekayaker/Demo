package com.demo.infraestructure.inbound.controllers;

import com.demo.aplicacion.usecases.BalanceCheckerUseCase;
import com.demo.aplicacion.usecases.ComplexBalancerUseCase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    private final BalanceCheckerUseCase balanceCheckerUseCase;

    @Qualifier("ComplexBalanceUseCaseImpl")
    private final ComplexBalancerUseCase complexBalancerUseCase;

    public ValidationController(BalanceCheckerUseCase balanceCheckerUseCase,
                                    ComplexBalancerUseCase complexBalancerUseCase) {
        this.balanceCheckerUseCase = balanceCheckerUseCase;
        this.complexBalancerUseCase = complexBalancerUseCase;
    }

    @PostMapping("/balance")
    public ResponseEntity<Boolean> balanceVerification(@RequestBody String input) {
        boolean result = balanceCheckerUseCase.checkBalance(input);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/complexBalance")
    public Mono<ResponseEntity<Boolean>> complexBalanceVerification(@RequestBody Map<String, String> inputMap) {
        return Mono.fromSupplier(() -> complexBalancerUseCase.checkBalance(inputMap.get("input")))
                .map(result -> ResponseEntity.ok().body(result))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
