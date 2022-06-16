package algorithm;

/**
 * @Description
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
示例 1：
输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
示例 2：
输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
 * @Author leslie
 * @Date 2022/6/16 18:54
 **/
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
        System.out.println(newClimbStairs(5));
    }
    //第一种用递归，f(n)=f(n-1)+f(n-2),但时间复杂度高
    public static int climbStairs(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    //第二种用for循环做了优化,滚动数组思路，时间复杂度为O(1)
    public static int newClimbStairs(int n){
        int p = 0,q = 0,r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}