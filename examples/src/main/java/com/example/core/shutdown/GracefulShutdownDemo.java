package com.example.core.shutdown;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 * Graceful Shutdown 설정 설명.
 *
 * application.yml에 아래 설정을 추가한다:
 *   server.shutdown=graceful
 *   spring.lifecycle.timeout-per-shutdown-phase=30s
 *
 * [동작 원리]
 * 1. SIGTERM 수신 → 새 요청 수락을 중단한다.
 * 2. 이미 처리 중인 요청은 timeout(기본 30초) 내에 완료를 기다린다.
 * 3. timeout 초과 시 강제 종료한다.
 *
 * [함정 1] server.shutdown=graceful 없이 컨테이너를 내리면
 *   → 처리 중인 요청이 잘려서 사용자에게 502/504 에러가 보인다.
 *   → 배포할 때마다 간헐적으로 에러가 튀는 원인이 된다.
 *
 * [함정 2] @PreDestroy에서 오래 걸리는 작업(DB 커넥션 정리 등)을 하면
 *   timeout-per-shutdown-phase 안에 끝나야 한다. 초과하면 강제 종료된다.
 *
 * [팁] Kubernetes에서는 preStop hook + graceful shutdown을 함께 쓴다.
 *   → preStop에서 sleep 5~10초를 넣어 로드밸런서가 라우팅을 제거할 시간을 준다.
 */
@Component
public class GracefulShutdownDemo {

    @PreDestroy
    void onShutdown() {
        System.out.println("애플리케이션 종료 중 — 리소스 정리 시작");
        // DB 커넥션 풀 반환, 캐시 플러시 등
        // 이 작업이 timeout-per-shutdown-phase 내에 끝나야 안전하다
        System.out.println("리소스 정리 완료");
    }
}
