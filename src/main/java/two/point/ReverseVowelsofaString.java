package two.point;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-12 17:36
 * @Descripe 反转字符串中的元音字符
 * Given s = "leetcode", return "leotcede".
 * @Version 0.0.1
 */
public class ReverseVowelsofaString {
    /**
     * 使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。
     * <p>
     * 为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
     */

    @Test
    public void test() {
        System.out.println(reverse("leetcode"));
    }

    private String reverse(String origion) {
        if (null == origion) {
            return null;
        }
        HashSet<Character> vowelsofa = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] afterChar = new char[origion.length()];
        int begin = 0;
        int end = origion.length() - 1;
        while (begin <= end) {
            char beginChar = origion.charAt(begin);
            char endChar = origion.charAt(end);
            if (vowelsofa.contains(beginChar)
                    && vowelsofa.contains(endChar)) {
                afterChar[begin] = endChar;
                afterChar[end] = beginChar;
                begin++;
                end--;
            } else if (vowelsofa.contains(beginChar)) {
                afterChar[end] = endChar;
                end--;
            } else {
                afterChar[begin] = beginChar;
                begin++;
            }
        }
        return String.valueOf(afterChar);
    }

}
