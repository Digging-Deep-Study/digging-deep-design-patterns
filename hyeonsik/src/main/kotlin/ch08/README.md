# 템플릿 메서드 패턴

게임 캐릭터 생성 시스템
   • 다양한 직업(전사, 마법사, 궁수 등)의 캐릭터 생성 프로세스를 템플릿화
   • 기본 속성 설정, 스킬 초기화, 장비 장착 등의 공통 로직 정의
   • 각 직업별 특수 능력과 스킬 구현을 하위 클래스에서 정