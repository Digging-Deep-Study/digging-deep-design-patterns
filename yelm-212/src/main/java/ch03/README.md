# 웹 요청 처리 파이프라인

- 상황: 기본 요청 핸들러에 로깅, 인증, 캐싱 기능을 조합하여 처리

- 구성:
  - RequestHandler 인터페이스: handle(Request)
  - BaseHandler(실제 비즈니스 로직)
  - LoggingDecorator, AuthenticationDecorator, CachingDecorator 등이 RequestHandler를 래핑하여 부가 기능 수행