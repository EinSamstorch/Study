package zhongxingpengyue;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/24 16:18
 */
public class Main1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int u = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
            System.out.println(height[i]);
        }

        Arrays.sort(height);

        if (h > u) {
            System.out.println(0);
        } else {
            for (int i = n - 1; i >= 0; i--) {
                h += height[i];
                if (h >= u) {
                    System.out.println(n - i);
                    break;
                }
            }
        }
    }
}
