package com.example.core.async;

import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.*;

/**
 * @Async 비동기 처리 데모.
 *
 * 핵심: @Async 메서드는 새 스레드에서 실행되므로
 * 호출자의 ThreadLocal 데이터(예: SecurityContext)가 전파되지 않는다.
 *
 * 면접 포인트: "@Async에서 인증 정보가 사라지는 이유?"
 * → ThreadLocal 기반이라 새 스레드에 복사되지 않기 때문.
 *
 * 해결 (spring-security 의존성 필요):
 *   SecurityContextHolder.setStrategyName(MODE_INHERITABLETHREADLOCAL)
 *   또는 DelegatingSecurityContextExecutor 사용.
 */
@Service
class NotificationService {

    @Async
    public void sendAsync(String message) {
        // 새 스레드에서 실행됨 — 호출자의 ThreadLocal 데이터 접근 불가
        // spring-security를 추가하면 SecurityContextHolder로 인증 정보 확인 가능
        // var auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("[Async] 스레드: " + Thread.currentThread().getName());
        System.out.println("[Async] 메시지: " + message);
    }
}

@Component
class AsyncDemo implements CommandLineRunner {
    private final NotificationService notificationService;
    AsyncDemo(NotificationService svc) { this.notificationService = svc; }

    @Override
    public void run(String... args) {
        System.out.println("[Async] 비동기 호출 시작");
        notificationService.sendAsync("주문 완료 알림");
    }
}
