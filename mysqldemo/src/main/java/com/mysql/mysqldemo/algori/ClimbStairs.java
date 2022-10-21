package com.mysql.mysqldemo.algori;

/**
 * @Description 动态规划暴力解法
 * @Author leslie
 * @Date 2022/10/20 18:20
 **/
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbNum(10));
    }
    public static int climbNum(int stairs){
        if(stairs < 1){
            return 0;
        }
        if(stairs == 1){
            return 1;
        }
        if(stairs == 2){
            return 2;
        }
        return climbNum(stairs - 1) + climbNum(stairs - 2);
    }
}
