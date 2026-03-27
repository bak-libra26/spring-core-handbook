package com.example.core.aop;

import org.springframework.stereotype.Service;

@Service
public class AopTargetService {
    public void publicMethod() {
        System.out.println("  publicMethod() 호출됨 — AOP 적용 O");
        internalCall(); // 내부 호출 — AOP 적용 X
    }

    public void internalCall() {
        System.out.println("  internalCall() — this.method()라 프록시 우회");
    }
}
