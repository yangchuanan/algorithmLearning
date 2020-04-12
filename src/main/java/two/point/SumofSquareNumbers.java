package two.point;

import org.junit.Test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-12 17:23
 * @Descripe 判断一个非负整数是否为两个整数的平方和
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * @Version 0.0.1
 */
public class SumofSquareNumbers {
    /**
     * 可以看成是在元素为 0~target
     * 的有序数组中查找两个数，使得这两个数的平方和为 target，
     * 如果能找到，则返回 true，表示 target 是两个整数的平方和。
     * 可以缩小范围为0-sqrt(target)
     */
    @Test
    public void Test() {
        System.out.println(isSumofSquareNum(5));
        System.out.println(isSumofSquareNum(3));
    }

    private boolean isSumofSquareNum(int target) {
        int end = (int) Math.sqrt(target);
        int begin = 0;
        while (begin < end) {
            int sum = begin * begin + end * end;
            if (sum == target) {
                return true;
            } else if (sum < target) {
                begin++;
            } else {
                end--;
            }
        }
        return false;
    }
}
