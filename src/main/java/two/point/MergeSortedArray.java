package two.point;

import org.junit.Test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-12 18:15
 * @Descripe 归并两个有序数组 把归并结果存到第一个数组上。
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 * @Version 0.0.1
 */
public class MergeSortedArray {

    @Test
    public void test(){
        int[] arry1=new int[]{1,2,3,0,0,0};
        int[] arry2=new int[]{2,5,6};
        merge(arry1,3,arry2,3);

        for(int i=0;i<6;i++){
            System.out.print(arry1[i]);
        }
    }


    /**
     * @Author Chuanan YANG
     * @DateTime 2020/4/12 18:29
     * @Description 需要从尾开始遍历，否则在 arry1 上归并得到的值会覆盖还未进行归并比较的值。
     */
    private void merge(int[] arry1, int m, int[] arry2, int n) {
        int end1 = m - 1;
        int end2 = n - 1;
        int mergeEnd = m + m - 1;
        while (end1 >= 0 && end2 >= 0) {
            if (arry1[end1] > arry2[end2]) {
                arry1[mergeEnd] = arry1[end1];
                end1--;
            } else {
                arry1[mergeEnd] = arry2[end2];
                end2--;
            }
            mergeEnd--;
        }
    }
}
