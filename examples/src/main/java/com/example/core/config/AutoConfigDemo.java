package com.example.core.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 자동 설정(Auto Configuration) 원리.
 *
 * 핵심: spring.factories / @AutoConfiguration + @Conditional 조합.
 *   1. 클래스패스에 특정 클래스가 있으면 → @ConditionalOnClass
 *   2. 사용자가 직접 빈을 등록하지 않았으면 → @ConditionalOnMissingBean
 *   3. 프로퍼티 값이 맞으면 → @ConditionalOnProperty
 *
 * 면접 포인트: "@ConditionalOnMissingBean 역할은?"
 * → 사용자 정의 빈이 없을 때만 자동 설정 빈을 등록한다.
 */
@Configuration
class CustomAutoConfig {

    // 프로퍼티 demo.feature.enabled=true 일 때만 빈 생성
    @Bean
    @ConditionalOnProperty(name = "demo.feature.enabled", havingValue = "true")
    public String featureFlag() {
        return "Feature ON";
    }

    // 위 빈이 없으면 기본값으로 등록
    @Bean
    @ConditionalOnMissingBean(name = "featureFlag")
    public String defaultFeatureFlag() {
        return "Feature OFF (기본값)";
    }
}

@Component
class AutoConfigDemo implements CommandLineRunner {
    private final String featureFlag;
    AutoConfigDemo(String featureFlag) { this.featureFlag = featureFlag; }

    @Override
    public void run(String... args) {
        System.out.println("[Config] " + featureFlag);
    }
}
