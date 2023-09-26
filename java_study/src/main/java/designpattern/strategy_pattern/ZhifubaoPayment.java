package designpattern.strategy_pattern;

public class ZhifubaoPayment implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("paid " + amount + " zhifubao");
    }
}
