# Spring Core/Boot Handbook

> IoC, AOP, Auto-Configuration부터 운영까지 — 공식 문서가 알려주지 않는 Why와 Pitfall을 다룹니다.

[![Blog](https://img.shields.io/badge/blog-bak--libra26.co.kr-green)](https://bak-libra26.co.kr)

## 시작하기

```bash
# Docker로 Spring Boot 앱 실행
cd docker
docker compose up -d

# 앱 로그 확인
docker compose logs -f app
```

## 목차

### 기초 — IoC와 DI

| # | 주제 | 블로그 |
|---|------|--------|
| 01 | 제어의 역전(IoC)과 의존성 주입(DI) | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/제어의%20역전(IoC)%20과%20의존성_주입(DI)) |
| 02 | 빈(Bean)이란 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/빈(Bean)%20이란) |
| 03 | 의존성 주입 방식 — 생성자 주입을 권장하는 진짜 이유 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/의존성%20주입%20방식%20—%20생성자%20주입을%20권장하는%20진짜%20이유) |
| 04 | @ComponentScan — 스프링은 빈을 어떻게 자동으로 찾아낼까 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/@ComponentScan%20—%20스프링은%20빈을%20어떻게%20자동으로%20찾아낼까) |
| 05 | @Configuration의 비밀 — 같은 메서드를 두 번 호출하면 어떻게 될까 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/@Configuration의%20비밀%20—%20같은%20메서드를%20두%20번%20호출하면%20어떻게%20될까) |

### 빈 라이프사이클과 스코프

| # | 주제 | 블로그 |
|---|------|--------|
| 06 | Bean 라이프사이클 — 스프링은 객체를 어떻게 만들고 관리할까 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/Bean%20라이프사이클%20—%20스프링은%20객체를%20어떻게%20만들고%20관리할까) |
| 07 | Bean 스코프 — 하나의 객체를 모두가 공유해도 괜찮을까 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/Bean%20스코프%20—%20하나의%20객체를%20모두가%20공유해도%20괜찮을까) |
| 08 | Environment와 Profile — 환경마다 다른 설정을 어떻게 관리할까 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/Environment와%20Profile%20—%20환경마다%20다른%20설정을%20어떻게%20관리할까) |

### AOP

| # | 주제 | 블로그 |
|---|------|--------|
| 09 | AOP 동작 원리 — 코드를 건드리지 않고 기능을 추가하는 방법 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/AOP%20동작%20원리%20—%20코드를%20건드리지%20않고%20기능을%20추가하는%20방법) |
| 10 | AOP와 self-invocation — 같은 클래스 내부 호출에서 AOP가 안 먹는 이유 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/AOP와%20self-invocation%20—%20같은%20클래스%20내부%20호출에서%20AOP가%20안%20먹는%20이유) |

### 이벤트와 스케줄링

| # | 주제 | 블로그 |
|---|------|--------|
| 11 | ApplicationEvent — 객체 간 결합을 끊는 이벤트 기반 설계 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/ApplicationEvent%20—%20객체%20간%20결합을%20끊는%20이벤트%20기반%20설계) |
| 12 | @Scheduled — 주기적 작업을 스프링에서 실행하는 방법 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/@Scheduled%20—%20주기적%20작업을%20스프링에서%20실행하는%20방법) |
| 13 | Spring Retry — 실패한 작업을 자동으로 재시도하는 전략 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/Spring%20Retry%20—%20실패한%20작업을%20자동으로%20재시도하는%20전략) |

### 로깅과 설정

| # | 주제 | 블로그 |
|---|------|--------|
| 14 | 외부 설정 — application.yml 값은 어떻게 코드에 주입될까 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/외부%20설정%20—%20application.yml%20값은%20어떻게%20코드에%20주입될까) |
| 15 | 로깅 아키텍처 — SLF4J, Logback, MDC를 스프링에서 활용하는 방법 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/로깅%20아키텍처%20—%20SLF4J,%20Logback,%20MDC를%20스프링에서%20활용하는%20방법) |

### Spring Boot

| # | 주제 | 블로그 |
|---|------|--------|
| 16 | Spring Boot란 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링부트/Spring%20Boot%20란) |
| 17 | 스프링 부트 시작 과정 — main 호출부터 요청 처리까지 벌어지는 일 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링부트/스프링%20부트%20시작%20과정%20—%20main%20호출부터%20요청%20처리까지%20벌어지는%20일) |
| 18 | Auto-Configuration — 스프링부트는 설정 없이 어떻게 동작할까 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/Auto-Configuration%20—%20스프링부트는%20설정%20없이%20어떻게%20동작할까) |
| 19 | 조건부 어노테이션 — @ConditionalOnClass가 자동 설정을 제어하는 원리 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링부트/조건부%20어노테이션%20—%20@ConditionalOnClass가%20자동%20설정을%20제어하는%20원리) |
| 20 | 내장 서버 — 스프링부트에 톰캣이 내장되어 있다는 게 무슨 뜻일까 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/내장%20서버%20—%20스프링부트에%20톰캣이%20내장되어%20있다는%20게%20무슨%20뜻일까) |

### 성능과 모듈

| # | 주제 | 블로그 |
|---|------|--------|
| 21 | 커넥션 풀 튜닝 — HikariCP 설정으로 DB 성능을 끌어올리는 방법 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/커넥션%20풀%20튜닝%20—%20HikariCP%20설정으로%20DB%20성능을%20끌어올리는%20방법) |
| 22 | 스레드 풀 튜닝 — Tomcat과 @Async의 스레드 설정 최적화 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/스레드%20풀%20튜닝%20—%20Tomcat과%20@Async의%20스레드%20설정%20최적화) |
| 23 | 멀티 모듈 프로젝트 — 스프링 부트에서 모듈을 나누는 전략과 구조 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링부트/멀티%20모듈%20프로젝트%20—%20스프링%20부트에서%20모듈을%20나누는%20전략과%20구조) |
| 24 | 커스텀 스타터 만들기 — 공통 기능을 라이브러리로 배포하는 방법 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링부트/커스텀%20스타터%20만들기%20—%20공통%20기능을%20라이브러리로%20배포하는%20방법) |

### 심화

| # | 주제 | 블로그 |
|---|------|--------|
| 25 | Spring Modulith — 모놀리스 안에서 모듈 경계를 지키는 방법 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/Spring%20Modulith%20—%20모놀리스%20안에서%20모듈%20경계를%20지키는%20방법) |
| 26 | GraalVM Native Image — 스프링 애플리케이션을 네이티브로 컴파일하는 방법 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/GraalVM%20Native%20Image%20—%20스프링%20애플리케이션을%20네이티브로%20컴파일하는%20방법) |

### 부록

| # | 주제 | 블로그 |
|---|------|--------|
| 27 | @PostConstruct, InitializingBean, @Bean(initMethod) — 초기화 전략 완전 비교 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/@PostConstruct,%20InitializingBean,%20@Bean(initMethod)%20—%20초기화%20전략%20완전%20비교) |
| 28 | Graceful Shutdown — 요청 처리 중에 서버가 종료되면 어떻게 될까 | [읽기](https://bak-libra26.co.kr/posts/개발/프레임워크/스프링/스프링%20코어/Graceful%20Shutdown%20—%20요청%20처리%20중에%20서버가%20종료되면%20어떻게%20될까) |

## Docker 환경

```bash
cd docker
docker compose up -d     # Spring Boot 앱 실행
docker compose down      # 종료
docker compose down -v   # 종료 + 데이터 삭제
```

- **Spring Boot App**: localhost:8080

## 이 핸드북의 차별점

1. **Why** — 공식 문서가 "이렇게 쓰세요"라면, 여기서는 "왜 이렇게 동작하는지" 설명합니다
2. **Pitfall** — 실무에서 터지는 함정을 모든 글에 포함합니다
3. **한국어** — 한국어로 가장 체계적인 Spring Core/Boot 시리즈를 목표로 합니다

## 저자

**sim.junghun** — Backend Engineer
- Blog: [bak-libra26.co.kr](https://bak-libra26.co.kr)
- GitHub: [@bak-libra26](https://github.com/bak-libra26)
