package designpattern.strategy_pattern;

/**
 * 支付功能使用策略模式，支持多种方式支付
 */
public interface PaymentStrategy {
    void pay(int amount);
}
