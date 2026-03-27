package com.example.core.hikari;

import org.springframework.stereotype.Component;

/**
 * HikariCP 주요 설정 + maxLifetime 주의점.
 *
 * application.yml 설정 예시:
 *   spring.datasource.hikari:
 *     maximum-pool-size: 10          # 기본 10, 보통 (CPU 코어 * 2) + 디스크 수
 *     minimum-idle: 10               # maximum-pool-size와 같게 유지 권장
 *     max-lifetime: 1800000          # 30분 (밀리초)
 *     connection-timeout: 3000       # 커넥션 대기 최대 3초
 *     idle-timeout: 600000           # 유휴 커넥션 10분 후 제거
 *
 * [함정 1] maxLifetime을 DB의 wait_timeout보다 길게 설정하면
 *   → DB가 먼저 커넥션을 끊는데, 애플리케이션은 그 커넥션을 유효하다고 판단한다.
 *   → "Communications link failure" 에러가 간헐적으로 발생한다.
 *   → 해결: maxLifetime = DB wait_timeout - 30초 (여유분)
 *
 * [함정 2] maximum-pool-size를 무작정 키우면
 *   → DB 서버의 max_connections 한계에 걸려서 전체 인스턴스가 커넥션을 못 잡는다.
 *   → 인스턴스 수 * pool-size < DB max_connections 공식을 기억하자.
 *
 * [팁] HikariCP는 connection-test-query 대신 JDBC4의 isValid()를 사용한다.
 *   → 별도 validation query 설정이 불필요하다 (오히려 설정하면 성능 저하).
 */
@Component
public class HikariDemo {

    // 이 클래스는 설정 설명용이다.
    // 실제 HikariCP 설정은 application.yml에서 관리한다.
    // 아래는 코드에서 DataSource 정보를 확인하는 예시:

    // @Autowired DataSource dataSource;
    //
    // @PostConstruct
    // void printPoolInfo() {
    //     if (dataSource instanceof HikariDataSource hds) {
    //         System.out.println("Pool size: " + hds.getMaximumPoolSize());
    //         System.out.println("Max lifetime: " + hds.getMaxLifetime());
    //     }
    // }
}
