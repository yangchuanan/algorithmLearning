package sort.problem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-16 23:04
 * @Descripe 按照频率对字符串进行排序
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * @Version 0.0.1
 */
public class SortCharacterByFrequency {
    @Test
    public void test() {
        System.out.println(sortedByFrequency("tree"));
    }

    /**
     * @Author Chuanan YANG
     * @DateTime 2020/4/16 23:08
     */
    private String sortedByFrequency(String origion) {
        // 统计频率
        Map<Character, Integer> frequencyMap = new HashMap<>(origion.length());
        for (int i = 0; i < origion.length(); i++) {
            frequencyMap.put(origion.charAt(i), frequencyMap.getOrDefault(origion.charAt(i), 0) + 1);
        }

        // 放到桶里面,桶下标为频率，每个桶是一个字符列表
        List<Character>[] buckets = new List[origion.length()];
        for (Character character : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(character);
            if (null == buckets[frequency]) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(character);
        }

        // 遍历桶，还原字符串
        StringBuilder result = new StringBuilder();
        for (int i = origion.length() - 1; i > 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            // 遍历i桶的字符
            for (int j = 0; j < buckets[i].size(); j++) {
                // 重复次数
                for (int f = 0; f < i; f++) {
                    result.append(buckets[i].get(j));
                }
            }

        }

        return result.toString();
    }
}
