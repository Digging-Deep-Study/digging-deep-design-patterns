```mermaid
classDiagram
    %% 추상 Game 클래스 (Context)
        class Game {
            <<abstract>>
            - title: String
            - paymentPlatform: PaymentPlatform
            + Game(title: String, paymentPlatform: PaymentPlatform)
            + play(): void
            + pay(amount: BigDecimal): void
            + setPaymentPlatform(platform: PaymentPlatform): void
            # gameType(): String
        }
    
        %% 구체적 Game 구현체
        class PcGame {
            + PcGame(title: String, paymentPlatform: PaymentPlatform)
            + gameType(): String
        }
        class GlobalPcGame {
            + GlobalPcGame(title: String, paymentPlatform: PaymentPlatform)
            + gameType(): String
        }
        class HybridGame {
            + HybridGame(title: String, paymentPlatform: PaymentPlatform)
            + gameType(): String
        }
        class SteamGame {
            + SteamGame(title: String, paymentPlatform: PaymentPlatform)
            + gameType(): String
        }
    %% 전략 인터페이스
    class PaymentPlatform {
        <<interface>>
        + pay(amount: BigDecimal): String
    }

    %% 구체적 결제 플랫폼 구현체
    class KcpPlatform {
        + pay(amount: BigDecimal): String
    }
    class MyCardPlatform {
        + pay(amount: BigDecimal): String
    }
    class ApplePlatform {
        + pay(amount: BigDecimal): String
    }
    class GooglePlatform {
        + pay(amount: BigDecimal): String
    }
    class SteamPlatform {
        + pay(amount: BigDecimal): String
    }

    %% 상속 관계
    PaymentPlatform <|-- KcpPlatform
    PaymentPlatform <|-- MyCardPlatform
    PaymentPlatform <|-- ApplePlatform
    PaymentPlatform <|-- GooglePlatform
    PaymentPlatform <|-- SteamPlatform

    Game <|-- PcGame
    Game <|-- GlobalPcGame
    Game <|-- HybridGame
    Game <|-- SteamGame

    %% 구성 관계
    Game o-- PaymentPlatform : uses
