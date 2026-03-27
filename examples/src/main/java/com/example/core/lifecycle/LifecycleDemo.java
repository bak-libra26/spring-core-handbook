package com.example.core.lifecycle;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 초기화 순서: @PostConstruct → afterPropertiesSet → initMethod
@Component
@Order(2)
public class LifecycleDemo implements CommandLineRunner, InitializingBean {
    @PostConstruct
    public void postConstruct() {
        System.out.println("1. @PostConstruct");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("2. InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void run(String... args) {
        System.out.println("=== Lifecycle Demo ===");
        System.out.println("실행 순서: @PostConstruct → afterPropertiesSet → CommandLineRunner");
        // 주의: @PostConstruct에서 다른 빈의 초기화가 끝났는지 보장 안 됨
    }
}
