package com.example.core.scope;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Singleton 빈 안에서 Prototype 빈을 주입받으면 생기는 문제 + ObjectProvider 해결.
 *
 * [함정] Singleton 빈은 딱 한 번만 생성되므로, 생성자로 주입받은 Prototype 빈도
 *   한 번만 만들어진다. → 매번 새 인스턴스를 원했는데 같은 객체가 계속 반환된다.
 *   → 면접에서 "Singleton + Prototype 조합의 함정"은 단골 질문이다.
 *
 * [해결] ObjectProvider<T>를 주입받아 getObject() 호출 시마다 새 인스턴스를 얻는다.
 */
@Component
@Scope("prototype")
class RequestToken {
    private final long createdAt = System.nanoTime();

    @Override
    public String toString() {
        return "RequestToken{createdAt=" + createdAt + "}";
    }
}

@Service
class ScopeDemo {

    // ── 잘못된 방법: 생성자 주입 → 항상 같은 인스턴스 ──
    // private final RequestToken token; // 이렇게 하면 매번 같은 객체

    // ── 올바른 방법: ObjectProvider로 지연 조회 ──
    private final ObjectProvider<RequestToken> tokenProvider;

    ScopeDemo(ObjectProvider<RequestToken> tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @PostConstruct
    void demo() {
        // 호출할 때마다 새로운 Prototype 인스턴스를 받는다
        System.out.println("토큰 1: " + tokenProvider.getObject());
        System.out.println("토큰 2: " + tokenProvider.getObject());
    }
}
