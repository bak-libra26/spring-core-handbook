package com.example.core.di;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 생성자 주입 — 테스트에서 Mock 주입이 쉽고, 불변 보장
@Component
@Order(1)
public class DIDemo implements CommandLineRunner {
    // ✅ 생성자 주입 (권장)
    private final MessageService messageService;

    public DIDemo(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void run(String... args) {
        System.out.println("=== DI Demo ===");
        System.out.println(messageService.getMessage());
        // 주의: @Autowired 필드 주입은 테스트에서 리플렉션 없이 Mock 주입 불가
    }
}
