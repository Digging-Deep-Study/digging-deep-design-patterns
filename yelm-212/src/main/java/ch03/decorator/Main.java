package ch03.decorator;

import ch03.decorator.decorators.Authentication;
import ch03.decorator.decorators.Caching;
import ch03.decorator.decorators.Compression;
import ch03.decorator.decorators.Logging;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== 데코레이터 패턴 예제 ===\n");
        
        // 기본 요청 생성
        Request request = new Request("/users", "user data");
        
        // 기본 핸들러
        System.out.println("1. 기본 핸들러");
        RequestHandler handler = new BaseHandler();
        System.out.println("결과: " + handler.handle(request) + "\n");
        
        // 로깅 데코레이터 추가
        System.out.println("2. 로깅 데코레이터 추가");
        handler = new Logging(handler);
        System.out.println("결과: " + handler.handle(request) + "\n");
        
        // 인증 데코레이터 추가
        System.out.println("3. 인증 데코레이터 추가");
        handler = new Authentication(handler);
        System.out.println("결과: " + handler.handle(request) + "\n");
        
        // 캐싱 데코레이터 추가
        System.out.println("4. 캐싱 데코레이터 추가");
        handler = new Caching(handler);
        System.out.println("결과: " + handler.handle(request) + "\n");
        
        // 동일한 요청 재처리 (캐시 활용)
        System.out.println("5. 동일한 요청 재처리 (캐시 활용)");
        System.out.println("결과: " + handler.handle(request) + "\n");
        
        // 같은 데코레이터 여러 번 적용 (로깅 2번)
        System.out.println("6. 로깅 데코레이터 중첩 적용");
        Request request2 = new Request("/products", "product data");
        RequestHandler multiLogging = new Logging(
                                      new Logging(
                                      new BaseHandler()));
        System.out.println("결과: " + multiLogging.handle(request2) + "\n");
        
        // 모든 데코레이터를 한 번에 적용
        System.out.println("7. 모든 데코레이터 적용 (한 번에 체이닝)");
        RequestHandler allDecorators = new Caching(
                                      new Authentication(
                                      new Logging(
                                      new Compression(
                                      new BaseHandler()))));
        System.out.println("결과: " + allDecorators.handle(new Request("/api/data", "complex data")) + "\n");
        
        // 같은 유형 데코레이터 여러 번 중첩 (압축 2번, 로깅 2번, 인증 1번)
        System.out.println("8. 다양한 데코레이터 중첩 적용");
        RequestHandler complexChain = new Compression(
                                     new Logging(
                                     new Authentication(
                                     new Logging(new Compression(new BaseHandler())))));
        System.out.println("결과: " + complexChain.handle(new Request("/api/complex", "nested data")) + "\n");
    }
}
