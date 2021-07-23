package 常间字符串算法;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/20 20:24
 */
public class Solution1 {

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public static String replace(StringBuilder str) {
        int len = str.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (String.valueOf(ch).equals(" ")) {
                result.append("%20");
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String replace2(StringBuilder sb) {
        return sb.toString().replaceAll("\\s", "%20");
    }
}
