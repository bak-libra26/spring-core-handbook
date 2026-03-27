# Spring Core 핸드북 예제

## 실행
```bash
cd examples
./gradlew bootRun
```

## 예제 목록
| 패키지 | 주제 | 핵심 |
|--------|------|------|
| di | 생성자 주입 | 필드 주입 vs 생성자 주입 |
| lifecycle | 초기화 순서 | @PostConstruct → afterPropertiesSet |
| aop | AOP + self-invocation | 내부 호출 시 프록시 우회 |
| event | ApplicationEvent | 동기/비동기 이벤트 |
