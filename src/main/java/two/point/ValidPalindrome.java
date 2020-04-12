package two.point;

import org.junit.Test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-12 18:00
 * @Descripe 回文字符串 可以删除一个字符，判断是否能构成回文字符串。
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * @Version 0.0.1
 */
public class ValidPalindrome {

    @Test
    public void test() {
        System.out.println(isPalidrome("abca"));
        System.out.println(isPalidrome("abcca"));
        System.out.println(isPalidrome("abcda"));
    }

    private boolean isPalidrome(String origion) {
        int begin = 0;
        int end = origion.length() - 1;
        while (begin <= end) {
            char beginChar = origion.charAt(begin);
            char endChar = origion.charAt(end);
            if (beginChar == endChar) {
                begin++;
                end--;
            } else {
                // 删掉左边字符或者删掉右边字符后分别判断是否为回文串
                return isPalindrome(origion, begin, end - 1)
                        || isPalindrome(origion, begin + 1, end);
            }
        }
        return true;
    }

    /**
     * @Author Chuanan YANG
     * @DateTime 2020/4/12 18:12
     * @Description 从指定位置判断是否为回文串
     */
    private boolean isPalindrome(String origion, int begin, int end) {
        while (begin <= end) {
            char beginChar = origion.charAt(begin);
            char endChar = origion.charAt(end);
            if (beginChar == endChar) {
                begin++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
