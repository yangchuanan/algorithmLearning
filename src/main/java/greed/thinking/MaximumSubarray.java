package greed.thinking;

import org.junit.Test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-24 20:08
 * @Descripe 给定一个整数数组 nums ，
 * 找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * @Version 0.0.1
 */
public class MaximumSubarray {
    @Test
    public void test() {
        System.out.println(sumMaxSequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

    }

    private int sumMaxSequence(int[] a) {
        if (null == a) {
            return Integer.MIN_VALUE;
        }
        int segment = a[0];
        int result = a[0];
        for (int i = 1; i < a.length; i++) {

            segment = Math.max(a[i], segment + a[i]);

            result = Math.max(result, segment);
        }
        return result;
    }
}
