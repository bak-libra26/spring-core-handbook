package com.example.core.aop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class AopDemo implements CommandLineRunner {
    private final AopTargetService service;

    public AopDemo(AopTargetService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        System.out.println("=== AOP Demo ===");
        service.publicMethod();
        // 주의: service.internalCall()은 프록시를 거치지 않아 AOP 미적용
        // self-invocation 문제 — 같은 클래스 내부 호출
    }
}
