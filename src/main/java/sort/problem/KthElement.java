package sort.problem;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-12 21:59
 * @Descripe 找到第 k 个大的元素。
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * @Version 0.0.1
 */
public class KthElement {

    @Test
    public void test() {
        int[] array = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(array, 2));
        System.out.println(findKthLargestHeap(array, 2));
        System.out.println(findKthLargetPartion(array, 2));
    }

    /**
     * 排序 ：时间复杂度 O(NlogN)，空间复杂度 O(1)
     */
    private int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 堆 ：时间复杂度 O(NlogK)，空间复杂度 O(K)。
     */
    private int findKthLargestHeap(int[] nums, int k) {
        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);
            // 堆中只保留K个元素，超过K个则出队，最小元素出队
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // 返回堆顶元素
        return pq.peek();
    }

    /**
     * @Author Chuanan YANG
     * @DateTime 2020/4/16 21:49
     * @Description 快速选择 时间复杂度 O(N)，空间复杂度 O(1)
     */
    private int findKthLargetPartion(int[] num, int k) {
        int kPosition = num.length - k;
        int low = 0;
        int high = num.length - 1;
        while (low < high) {
            int positon = partion(num, low, high);
            if (kPosition == positon) {
                return num[positon];
            } else if (kPosition < positon) {
                high = positon - 1;
            } else {
                low = positon + 1;
            }
        }
        return num[kPosition];

    }


    /**
     * @Author Chuanan YANG
     * @DateTime 2020/4/16 22:07
     * @Description 以num[begin]为中心元素进行分组，左侧为小于等于，右侧为大于等于
     */
    private int partion(int[] num, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (num[++i] < num[low] && i < j) {

            }
            while (num[--j] > num[low] && j > i) {

            }
            if (i >= j) {
                break;
            }
            swap(num, i, j);
        }
        swap(num, low, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
