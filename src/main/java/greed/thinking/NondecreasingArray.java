package greed.thinking;

import org.junit.Test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-24 19:48
 * @Descripe Given an array with n integers,
 * your task is to check if it could become non-decreasing by modifying at most 1element.
 * <p>
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 * <p>
 * Example 1:
 * <p>
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * @Version 0.0.1
 */
public class NondecreasingArray {
    @Test
    public void test() {
        System.out.println(isNonDecreasing(new int[]{4, 2, 3}));
        System.out.println(isNonDecreasing(new int[]{4, 2, 1}));
        System.out.println(isNonDecreasing(new int[]{-1, 4, 2, 3}));
        System.out.println(isNonDecreasing(new int[]{2, 3, 3, 2, 4}));
    }

    /**
     * 给一个数组，最多有1次修改某个数字的机会，问能不能将数组变为非递减数组。
     * 看下面三个例子
     * 4，2，3
     * -1，4，2，3
     * 2，3，3，2，4
     * 通过分析上面三个例子可以发现，当发现后面的数字小于前面的数字时，
     * 有时候需要修改前面较大的数字(比如前两个例子需要修改4)，
     * 有时候却要修改后面较小的那个数字(比如前第三个例子需要修改2)，那么有什么内在规律吗？
     * 判断修改那个数字其实跟再前面一个数的大小有关系，首先如果再前面的数不存在，比如例子1，4前面没有数字了
     * 直接修改前面的数字为当前的数字2即可。而当再前面的数字存在，并且小于当前数时，比如例子2，-1小于2，
     * 还是需要修改前面的数字4为当前数字2；如果再前面的数大于当前数，比如例子3，3大于2，
     * 需要修改当前数2为前面的数3。这是修改的情况，由于只有一次修改的机会，
     * 所以用一个变量cnt，初始化为1，修改数字后cnt自减1，当下次再需要修改时，如果cnt已经为0了，
     * 直接返回false。遍历结束后返回true
     */
    private boolean isNonDecreasing(int a[]) {
        if (null == a) {
            return false;
        }
        int count = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                // 已经没有修改机会了
                if (count == 0) {
                    return false;
                }

                if (i - 1 < 0 || a[i - 1] < a[i]) {
                    a[i] = a[i + 1];
                } else {
                    a[i + 1] = a[i];
                }
                count--;
            }

        }
        return true;

    }
}
