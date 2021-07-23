package 常间字符串算法;

/**
 * Leetcode: LeetCode: 最长回文子串 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 *
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/20 21:44
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        String res = s.substring(0, 1);

        // 中心位置枚举到len - 2就可以
        for (int i = 0; i < len - 1; i++) {
            // 以s[i]为中心的最长回文子串
            String oddStr = centerSpread(s, i, i);
            // 以s[i]和s[i + 1]为中心的最长回文子串
            String evenStr = centerSpread(s, i, i + 1);
            res = res.length() > oddStr.length() ? res : oddStr;
            res = res.length() > evenStr.length() ? res : evenStr;
        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        // left == right时，此时回文中心是一个字符，回文串的长度时奇数
        // right = left + 1时，回文串的中心是一个空隙，回文串长度是偶数
        int len = s.length();
        while (left >= 0 && right < len) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出while循环是，恰好满足s.charAt(left) != s.charAt(right)
        // 因此，不能取i，不能取j
        return s.substring(left + 1, right);
    }
}
