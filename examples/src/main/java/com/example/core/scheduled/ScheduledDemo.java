package com.example.core.scheduled;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

/**
 * @Scheduled + 스레드 풀 설정 — 단일 스레드 밀림 문제.
 *
 * [함정] Spring의 기본 스케줄러는 스레드가 1개다.
 *   → @Scheduled 작업이 2개 이상이면, 앞 작업이 늦어질 때 뒤 작업도 밀린다.
 *   → "1분마다 실행"인데 2분, 3분 뒤에 몰아서 실행되는 현상이 발생한다.
 *
 * [해결] ThreadPoolTaskScheduler를 빈으로 등록하고 poolSize를 늘린다.
 */
@Configuration
@EnableScheduling
class ScheduledConfig {

    @Bean
    ThreadPoolTaskScheduler taskScheduler() {
        var scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(4); // 기본 1 → 4로 늘려서 밀림 방지
        scheduler.setThreadNamePrefix("sched-");
        return scheduler;
    }
}

@Component
class ScheduledDemo {

    // 5초마다 실행 — 스레드 풀이 1개면 heavyJob과 서로 밀린다
    @Scheduled(fixedRate = 5000)
    void lightJob() {
        System.out.println("[light] " + Thread.currentThread().getName());
    }

    // 10초마다 실행 — 오래 걸리는 작업
    @Scheduled(fixedRate = 10000)
    void heavyJob() throws InterruptedException {
        System.out.println("[heavy] 시작 " + Thread.currentThread().getName());
        Thread.sleep(8000); // 8초 소요 — 단일 스레드면 lightJob을 3초 밀린다
        System.out.println("[heavy] 완료");
    }
}
