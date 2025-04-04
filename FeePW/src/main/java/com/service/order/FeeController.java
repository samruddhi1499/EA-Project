package com.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/fees")
public class FeeController {

    @Autowired
    private FeeRepository feeRepository;

    @PostMapping("/calculate")
    public Mono<ResponseEntity<Double>> calculateFee(@RequestBody Fee record) {
        double fee = 0.01 * record.getPrice() * record.getQuantity();
        record.setFee(fee);

        return feeRepository.save(record)
                .map(saved -> ResponseEntity.ok(saved.getFee()));
    }
}
