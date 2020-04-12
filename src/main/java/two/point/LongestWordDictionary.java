package two.point;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-12 18:59
 * @Descripe 删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，
 * 找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * Output:
 * "apple"
 * @Version 0.0.1
 */
public class LongestWordDictionary {

    @Test
    public void test(){
        System.out.println(findLongest("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
    }

    private String findLongest(String s, List<String> dic) {
        String longest = "";
        for (String p : dic) {
            // 取最长的
            // 长度相等则取字典排序最小的
            if (p.length() < longest.length()
                    || (p.length() == longest.length() && p.compareTo(longest) > 0)) {
                continue;
            }
            if (isSubStr(s, p)) {
                longest = p;
            }
        }
        return longest;
    }

    /**
     * 通过删除字符串 s 中的一个字符能得到字符串 t，可以认为 t 是 s 的子序列，
     * 我们可以使用双指针来判断一个字符串是否为另一个字符串的子序列。
     */
    private boolean isSubStr(String s, String target) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < target.length()) {
            // target 串中存在对应的字符
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }

        // j走到target串的最后一个字符
        if (j == target.length()) {
            return true;
        }
        return false;
    }

}
