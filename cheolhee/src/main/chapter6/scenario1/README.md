# 프록시(Proxy) 패턴 예제

## 시나리오
AI 이미지 생성 API 접근 제한

## 컨텍스트

클라이언트는 ImageGenerator 객체에 요청하지만, 실제 구현체는 비용이 높은 외부 API.

프록시 객체 ImageGeneratorProxy가 내부적으로 캐시를 두거나, 하루 생성 횟수 제한 등을 관리.

외부 API 호출 전에 프록시가 검증을 수행함.