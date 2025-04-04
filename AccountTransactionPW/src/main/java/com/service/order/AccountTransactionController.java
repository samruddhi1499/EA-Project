package com.service.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transactions")
public class AccountTransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/reserve")
    public Mono<ResponseEntity<String>> reserveStock(@RequestBody Transaction tx) {
        tx.setStatus("RESERVED");
        return transactionRepository.save(tx)
                .map(saved -> ResponseEntity.ok("Stock reserved for user: " + saved.getUserId()));
    }
}
