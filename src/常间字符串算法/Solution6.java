package 常间字符串算法;

import java.util.Scanner;

/**
 * 括号匹配深度
 * <p>
 * 空串""的深度是0
 * 如果字符串"X"的深度是x,字符串"Y"的深度是y,那么字符串"XY"的深度为max(x,y)
 * 如果"X"的深度是x,那么字符串"(X)"的深度是x+1
 * <p>
 * 输入:
 * (())
 * 输出:
 * 2
 *
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/20 22:11
 */
public class Solution6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            max = Math.max(max, count);
        }
        sc.close();
        System.out.println(max);
    }
}
