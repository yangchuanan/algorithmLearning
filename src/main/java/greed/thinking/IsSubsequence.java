package greed.thinking;

import org.junit.Test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-19 17:04
 * @Descripe 判断是否为子序列
 * s = "abc", t = "ahbgdc"
 * Return true.
 * @Version 0.0.1
 */
public class IsSubsequence {
    @Test
    public void test() {
        System.out.println(isSubsequence("abc","ahbgdc"));
    }

    /**
     * 遍历子序列,如果相等,子序列和主序列都同时向后移动,
     * 如果不相等,主序列移动,子序列不移动.
     * 如果到达主序列的末尾,返回false,其他返回true.
     */
    private boolean isSubsequence(String s, String t) {
        if (t == null || t.equals("")) {
            return false;
        }
        int sflag = 0;
        int tflag = 0;
        while (sflag < s.length()) {
            // 母串已经遍历完成
            if (tflag == t.length()) {
                break;
            }
            while (tflag < t.length()) {
                // 相等指针同时向右移动
                if (s.charAt(sflag) == t.charAt(tflag)) {
                    ++sflag;
                    ++tflag;
                } else {
                    // 不相等，母串向右移动
                    ++tflag;
                }
            }
        }
        // 子串已经遍历完成说明是子串
        return sflag == s.length();
    }
}
