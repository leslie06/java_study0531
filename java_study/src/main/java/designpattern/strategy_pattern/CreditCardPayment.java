package designpattern.strategy_pattern;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("paid " + amount + " credit pay");
    }
}
