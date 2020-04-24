package greed.thinking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-24 20:46
 * @Descripe A string S of lowercase letters is given.
 * We want to partition this string into as many parts as possible
 * so that each letter appears in at most one part, and return a list of integers
 * representing the size of these parts.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect,
 * because it splits S into less parts.
 * @Version 0.0.1
 */
public class PartitionLabels {
    @Test
    public void test() {
        System.out.println(splitStr("ababcbacadefegdehijhklij"));

    }

    /**
     * 这道题给了一个字符串S，然我们将其尽可能多的分割为子字符串，
     * 条件是每种字符最多只能出现在一个子串中。比如题目汇总的例子，字符串S中有多个a，
     * 这些a必须只能在第一个子串中，再比如所有的字母e值出现在了第二个子串中。
     * 那么这道题的难点就是如何找到字符串的断点，即拆分成为子串的位置。仔细观察题目中的例子，
     * 可以发现一旦某个字母多次出现了，那么其最后一个出现位置必须要在当前子串中，字母a，e，和j，
     * 分别是三个子串中的结束字母。所以关注的是每个字母最后的出现位置，
     * 可以使用一个 HashMap 来建立字母和其最后出现位置之间的映射
     */
    private List<Integer> splitStr(String str) {
        // 记录每个字母最后的索引位置
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            lastIndexMap.put(str.charAt(i), str.lastIndexOf(str.charAt(i)));
        }

        int curr = 0;
        List<Integer> numbers = new ArrayList<>();
        while (curr < str.length()) {
            int end = lastIndexMap.get(str.charAt(curr));
            for (int i = curr; i < end && i < str.length(); i++) {
                // 更新子串的结束位置
                if (lastIndexMap.get(str.charAt(i)) > end) {
                    end = lastIndexMap.get(str.charAt(i));
                }
            }
            // 一个子串寻找结束,还未分割完成
            if (end < str.length()) {
                numbers.add(str.substring(curr, end + 1).length());
            }
            // 更新起始位置
            curr = end + 1;
        }
        return numbers;
    }
}
