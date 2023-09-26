package designpattern.strategy_pattern;

public class PaymentStrategyTest {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        paymentContext.setPaymentStrategy(new CreditCardPayment());
        paymentContext.executePayment(100);

        paymentContext.setPaymentStrategy(new ZhifubaoPayment());
        paymentContext.executePayment(200);


    }
}
