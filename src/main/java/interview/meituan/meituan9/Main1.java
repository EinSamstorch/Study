package interview.meituan.meituan9;

import java.util.Scanner;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/26 9:59
 */

public class Main1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n, m, a, b;
            n = s.nextInt();
            m = s.nextInt();
            a = s.nextInt();
            b = s.nextInt();
            int[] cakes = new int[m];

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                cakes[i] = s.nextInt();
                min = Math.min(min, cakes[i]);
                max = Math.max(max, cakes[i]);
            }
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            // 已经满足要求的蛋糕数量
            int num = 0;
            if (min == a) {
                num++;
            }
            if (max == b) {
                num++;
            }
            // 可以现烤的蛋糕数量
            int rest = n - m;
            if (rest + num >= 2) {
                if (min < a || max > b)
                    System.out.println("NO");
                else
                    System.out.println("YES");
            } else System.out.println("NO");
        }
    }
}