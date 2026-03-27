package com.example.core.event;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class EventDemo implements CommandLineRunner {
    private final ApplicationEventPublisher publisher;

    public EventDemo(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void run(String... args) {
        System.out.println("=== Event Demo ===");
        publisher.publishEvent(new OrderCreatedEvent("ORDER-001"));
        // 주의: 기본은 동기 실행 — 리스너 예외가 발행자에게 전파됨
    }
}
