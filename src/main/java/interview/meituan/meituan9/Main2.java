package interview.meituan.meituan9;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/26 0:29
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        Arrays.sort(scores);
        int y = scores[n - x];
        int count = 0;
        for (int score : scores) {
            if (score >= y && score > 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
