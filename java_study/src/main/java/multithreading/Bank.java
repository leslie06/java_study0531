package multithreading;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/29 21:25
 **/
public class Bank {
    private final double[] accounts;

    private ReentrantLock bankLock = new ReentrantLock();

    public Bank(int n ,double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    /**
     * 把钱从一个账户转到另一个账户
     * @param from
     * @param to
     * @param amount
     */
    public void transfer(int from,int to,double amount){
        if(accounts[from] < amount){
            return;
        }
        bankLock.lock();
        try{
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d",amount,from,to);
            accounts[to] += amount;
            System.out.printf(" Total Balance:%10.2f%n",getTotalBalance());
        }finally {
            bankLock.unlock();
        }

    }

    /**
     * 获取所有账户的余额总和
     * @return
     */
    public double getTotalBalance(){
        double sum = 0;
        for(double a : accounts){
            sum += a;
        }
        return sum;
    }

    /**
     * 获取银行账户的数量
     * @return
     */
    public int size(){
        return accounts.length;
    }
}
