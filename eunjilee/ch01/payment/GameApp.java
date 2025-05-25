package ch01.payment;

import java.math.BigDecimal;

public class GameApp {

  //추상 Game 클래스
  public static abstract class Game {
    private final String title;
    private PaymentPlatform paymentPlatform;

    public Game(final String title, final PaymentPlatform paymentPlatform) {
      this.title = title;
      this.paymentPlatform = paymentPlatform;
    }

    protected abstract String gameType(); //게임 타입(PC 국내, PC 글로벌, iOS+PC, Steam 등)

    public void setPaymentPlatform(PaymentPlatform paymentPlatform) {
      this.paymentPlatform = paymentPlatform;
    }

    public void play() {
      System.out.printf("'%s' %s 게임을 플레이합니다.%n", title, gameType());
    }

    public void pay(BigDecimal amount) {
      System.out.println(paymentPlatform.pay(amount));
    }
  }

  //구체 Game 클래스
  public static class PcGame extends Game {
    public PcGame(String title, PaymentPlatform paymentPlatform) {
      super(title, paymentPlatform);
    }

    @Override
    protected String gameType() {
      return "PC 국내";
    }
  }

  public static class GlobalPcGame extends Game {
    public GlobalPcGame(String title, PaymentPlatform paymentPlatform) {
      super(title, paymentPlatform);
    }

    @Override
    protected String gameType() {
      return "PC 글로벌";
    }
  }

  public static class HybridGame extends Game {
    public HybridGame(String title, PaymentPlatform paymentPlatform) {
      super(title, paymentPlatform);
    }

    @Override
    protected String gameType() {
      return "IOS+PC";
    }
  }

  public static class SteamGame extends Game {
    public SteamGame(String title, PaymentPlatform paymentPlatform) {
      super(title, paymentPlatform);
    }

    @Override
    protected String gameType() {
      return "Steam";
    }
  }

  //전략 인터페이스
  public interface PaymentPlatform {
    String pay(BigDecimal amount);
  }

  //구체 결제 플랫폼
  public static class KcpPlatform implements PaymentPlatform {
    @Override
    public String pay(BigDecimal amount) {
      return "KCP " + amount.toPlainString() + "원 결제 완료";
    }
  }

  public static class MyCardPlatform implements PaymentPlatform {
    @Override
    public String pay(BigDecimal amount) {
      return "MyCard " + amount.toPlainString() + "원 결제 완료";
    }
  }

  public static class ApplePlatform implements PaymentPlatform {
    @Override
    public String pay(BigDecimal amount) {
      return "Apple App Store " + amount.toPlainString() + "원 결제 완료";
    }
  }

  public static class GooglePlatform implements PaymentPlatform {
    @Override
    public String pay(BigDecimal amount) {
      return "Google Windows " + amount.toPlainString() + "원 결제 완료";
    }
  }

  public static class SteamPlatform implements PaymentPlatform {
    @Override
    public String pay(BigDecimal amount) {
      return "Steam " + amount.toPlainString() + "원 결제 완료";
    }
  }

  public static void main(String[] args) {
    PaymentPlatform kcp = new KcpPlatform();
    PaymentPlatform myCard = new MyCardPlatform();
    PaymentPlatform apple = new ApplePlatform();
    PaymentPlatform google = new GooglePlatform();
    PaymentPlatform steamPlat = new SteamPlatform();

    Game pc = new PcGame("AAKR", kcp);
    Game global = new GlobalPcGame("AAGL", myCard);
    Game hybrid = new HybridGame("BBKR", apple);
    Game steam = new SteamGame("CCGL", steamPlat);

    pc.play();
    pc.pay(BigDecimal.valueOf(1000));
    global.play();
    global.pay(BigDecimal.valueOf(2000));
    hybrid.play();
    hybrid.pay(BigDecimal.valueOf(3000));

    //결제 플랫폼 Google Windows로 변경
    hybrid.setPaymentPlatform(google);
    hybrid.pay(BigDecimal.valueOf(3000));

    steam.play();
    steam.pay(BigDecimal.valueOf(4000));
  }
}
