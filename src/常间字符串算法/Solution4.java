package 常间字符串算法;

/**
 * LeetCode: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/20 21:31
 */
public class Solution4 {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();

        while (left < right) {
            char l = chars[left];
            char r = chars[right];
            // 从头和尾开始向中间遍历，字符不是字母和数字的情况就跳过
            if (!Character.isLetterOrDigit(l)) {
                left++;
            } else if (!Character.isLetterOrDigit(r)) {
                right--;
            } else {
                // 判断两者是否相等
                if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                    // 不相等的话直接返回false
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
