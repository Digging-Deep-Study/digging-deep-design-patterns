# 팩토리 메서드 패턴

## 게임 아이템 생성기

- 상황: 무기, 방어구 등 아이템 유형별로 생성 로직을 캡슐화
- 구성:
  - Item 인터페이스
  - ItemCreator 추상 클래스에 createItem(type) 팩토리 메서드 선언
  - WeaponCreator, ArmorCreator 서브클래스가 각각 구체 아이템 인스턴스 생성

# 추상 팩토리 패턴

## 자동차 부품 생산 시스템

- 상황: 승용차(FamilyCar), 트럭(Truck)용 엔진, 휠, 차체를 패밀리 단위로 생성
- 구성:
  - CarFactory 인터페이스: createEngine(), createWheel(), createBody()
  - FamilyCarFactory, TruckFactory가 각각 엔진·휠·차체 구현체 반환
  - 클라이언트는 차량 종류 팩토리만 바꾸면 관련 부품 일괄 생성