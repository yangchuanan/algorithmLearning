package two.point;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-12 17:06
 * @Descripe 在有序数组中找出两个数，使它们的和为 target
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * @Version 0.0.1
 */
@RunWith(JUnit4.class)
public class TwoSumII {
    /**
     * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。
     * 指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     * <p>
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     * 数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
     */
    @Test
    public void Test() {
        int[] sortedArray = {2, 7, 11, 15};
        System.out.println(twoSum(sortedArray, 9));
    }

    private ArrayList<Integer> twoSum(int[] sortedArray, int target) {
        if (sortedArray == null) {
            return null;
        }
        int begin = 0;
        int end = sortedArray.length - 1;
        ArrayList<Integer> indexs = new ArrayList<>(2);
        while (begin < end) {
            int sum = sortedArray[begin] + sortedArray[end];
            if (sum == target) {
                indexs.add(begin + 1);
                indexs.add(end + 1);
                return indexs;
            } else if (sum < target) {
                begin++;
            } else {
                end--;
            }
        }
        return null;
    }


}
