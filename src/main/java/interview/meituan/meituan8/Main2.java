package interview.meituan.meituan8;

import java.util.Scanner;

/**
 * 此题本质是求子数组的最大累加和
 *
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/26 14:35
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        char[] chars = str.trim().toCharArray();
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'E') {
                sum++;
            }
            if (chars[i] == 'F') {
                sum--;
            }
            maxSum = Math.max(maxSum, sum);
            // 累加和小于0就重新计算
            sum = Math.max(sum, 0);
        }
    }
}
