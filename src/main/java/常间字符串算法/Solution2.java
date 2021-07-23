package 常间字符串算法;

import java.util.Arrays;

/**
 * 最长公共前缀
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/20 20:40
 */
public class Solution2 {

    public static String longestCommonPrefix(String[] strs) {
        if (!checkStrs(strs)) {
            return "";
        }
        int len = strs.length;

        StringBuilder sb = new StringBuilder();
        // 给字符串数组的元素按照升序排序(包含数字的话，数字会在前面）
        Arrays.sort(strs);
        int m = strs[0].length();
        int n = strs[len - 1].length();
        int num = Math.min(m, n);

        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    private static boolean checkStrs(String[] strs) {
        boolean flag = false;
        if (strs != null) {
            // 遍历strs检查元素值
            for (String str : strs) {
                if (str != null && str.length() != 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    // 测试
    public static void main(String[] args) {
//        String[] strs = {"customer", "car", "cat"};
//        String[] strs = {"customer", "car", null};//空串
//        String[] strs = {};//空串
        String[] strs = null;//空串
        System.out.println(Solution2.longestCommonPrefix(strs));// c
    }
}
