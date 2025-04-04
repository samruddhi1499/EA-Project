package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

	  @Autowired private OrderRepository orderRepository;
	    @Autowired private WebClient.Builder webClientBuilder;

	    public Mono<Order> placeOrder(Order order) {
	        order.setStatus("PLACED");

	        return orderRepository.save(order)
	            .flatMap(savedOrder -> {
	                Mono<String> reserve = webClientBuilder.build()
	                    .post()
	                    .uri("http://accounttransactionpw/api/transactions/reserve")
	                    .bodyValue(savedOrder)
	                    .retrieve()
	                    .bodyToMono(String.class);

	                Mono<Double> fee = webClientBuilder.build()
	                    .post()
	                    .uri("http://feepw/api/fees/calculate")
	                    .bodyValue(savedOrder)
	                    .retrieve()
	                    .bodyToMono(Double.class)
	                    .doOnNext(f -> System.out.println("Calculated Fee: " + f));

	                return Mono.when(reserve, fee).thenReturn(savedOrder);
	            });
	    }

	    public Mono<Order> getOrderById(String id) {
	        return orderRepository.findById(id);
	    }
	}


