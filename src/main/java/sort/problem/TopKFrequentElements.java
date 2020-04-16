package sort.problem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-16 22:24
 * @Descripe 返回出现频率最高的K个元素
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * @Version 0.0.1
 */
public class TopKFrequentElements {

    @Test
    public void Test() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(topKFreqent(nums, 2));
    }

    /**
     * @Author Chuanan YANG
     * @DateTime 2020/4/16 22:26
     * @Description 设置若干个桶，每个桶存储出现频率相同的数。桶的下标表示数出现的频率，
     * 即第 i 个桶中存储的数出现的频率为 i。
     * 把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。
     */
    private List<Integer> topKFreqent(int[] nums, int k) {
        // 统计频率
        Map<Integer, Integer> frequencyMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }

        // 放到不同的桶里
        List<Integer>[] buckets = new List[nums.length];
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            // 桶不存在则创建
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            // 频率  key1,key2....
            buckets[frequency].add(key);
        }

        // 通过排序获取结果
        List<Integer> topK = new ArrayList<>(k);
        for (int i = buckets.length - 1; i > 0; i--) {
            // 已经找到k个元素
            if (topK.size() >= k) {
                break;
            }
            // 频率不存在的桶跳过
            if (null == buckets[i]) {
                continue;
            }
            // 填充桶里所有元素
            if (buckets[i].size() <= k - topK.size()) {
                topK.addAll(buckets[i]);
            } else {
                // 选取部分元素
                for (int j = 0; j < k - topK.size(); j++) {
                    topK.add(buckets[i].get(j));
                }
            }
        }

        return topK;
    }
}
