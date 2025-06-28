# 상태 패턴 예제

## 시나리오

TCP 연결 상태 관리

## 컨텍스트

상태: Closed, Listening, Established, Fin-Wait

수신 이벤트에 따라 상태 전이

Closed 상태에서 open() 호출 → Listening

Established에서 close() 호출 → Fin-Wait 등
