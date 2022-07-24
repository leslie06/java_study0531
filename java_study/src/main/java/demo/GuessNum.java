package demo;

import java.util.Random;
import java.util.Scanner;

/**
 * @Description系统产生一个50-60之间的随机数，请猜出这个数字是多少。
 * （猜中之后程序就结束，没有猜中则继续猜）
 * @Author leslie
 * @Date 2022/7/24 15:43
 **/
public class GuessNum {
    public static void main(String[] args) {
        //随机产生50-60的数
        Random random = new Random();
        int target = random.nextInt(11) + 50;
        System.out.println(target);
        System.out.println("系统产生一个50-60之间的随机数");
        //键盘输入一个数
        Scanner sc = new Scanner(System.in);
        while(true){
            //输入数字必须在循环里面，否则会无限打印
            int num = sc.nextInt();
            if(num > target){
                System.out.println("大了，请继续猜");
            }
            if(num < target){
                System.out.println("小了，请继续猜");
            }
            if(num == target){
                System.out.println("恭喜猜对了,跳出循环");
                break;
            }
        }
    }
}
