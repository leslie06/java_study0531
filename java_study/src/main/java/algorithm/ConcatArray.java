package algorithm;

import java.util.Arrays;

/**
 * @Description 两个排序数组合并成一个有序数组
 * @Author leslie
 * @Date 2022/8/15 17:29
 **/
public class ConcatArray {
    public static void main(String[] args) {
        int[] arrayA = {1,3,5,0,0,0};
        int[] arrayB = {2,4,6};
        int[] result = concat(arrayA, 3, arrayB, 3);
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));

    }

    public static int[] concat(int[] arrayA,int m,int[] arrayB,int n){
        for(int i = 0;i < n;i++){
            arrayA[m + i] = arrayB[i];
        }
        return arrayA;
    }
}
