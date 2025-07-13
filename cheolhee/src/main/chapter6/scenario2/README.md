# 복합(Composite) 패턴 예제

## 시나리오

IoT 스마트홈 시스템 (Observer + Command + State)

## 컨텍스트

장치들(전등, 에어컨, 보일러 등)은 Command로 동작 제어됨.

사용자의 모바일 앱은 장치 상태(State)에 따라 뷰(UI)가 동적으로 바뀜.

장치 상태가 바뀌면 Observer를 통해 UI에 실시간 반영.

복합적으로 동작하는 제어 시스템 구성.