package com.example.core.retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @Retryable + 멱등성 주의 예제.
 *
 * [함정 1] 재시도 대상 메서드가 멱등(idempotent)하지 않으면
 *   → 결제, 메일 발송 등이 여러 번 실행될 수 있다.
 *   → 재시도를 걸기 전에 "이 작업을 두 번 해도 괜찮은가?"를 반드시 확인한다.
 *
 * [함정 2] @Retryable은 AOP 기반이므로, 같은 클래스 내부 호출(self-invocation)에서는
 *   프록시를 타지 않아 재시도가 동작하지 않는다.
 *
 * [팁] backoff의 multiplier를 설정하면 지수 백오프(1초→2초→4초)가 된다.
 *   → 외부 API 호출 시 서버 부담을 줄여주므로 면접에서 좋은 인상을 준다.
 */
@EnableRetry
@Service
public class RetryDemo {

    private int attempt = 0;

    @Retryable(
            retryFor = RuntimeException.class,
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000, multiplier = 2.0)
    )
    public String callExternalApi() {
        attempt++;
        System.out.println("시도 #" + attempt);
        if (attempt < 3) {
            throw new RuntimeException("외부 API 일시적 장애");
        }
        // 멱등한 조회 API여서 재시도해도 안전하다
        return "성공";
    }

    // ⚠️ 아래처럼 결제 같은 비멱등 작업에 @Retryable을 걸면 위험하다
    // @Retryable(...)
    // public void processPayment(Order order) { ... }
}
