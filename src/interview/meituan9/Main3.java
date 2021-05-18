package interview.meituan9;

import java.util.Scanner;

/**
 * 回转寿司
 *
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/26 10:46
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int sum = 0;
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            int len = arr.length;
            // 初始化两个dp数组
            int[] dpMax = new int[len];
            int[] dpMin = new int[len];
            int max = arr[0];
            int min = arr[0];
            dpMax[0] = arr[0];
            dpMin[0] = arr[0];

            for (int k = 1; k < len; k++) {
                dpMax[k] = Math.max(arr[k], arr[k] + dpMax[k - 1]);
                dpMin[k] = Math.min(arr[k], arr[k] + dpMin[k - 1]);
                max = Math.max(max, dpMax[k]);
                min = Math.min(min, dpMin[k]);
            }
            // 总和减去最小值的思路太棒了
            // 最大和有两种可能，一个是选取的元素中首尾没有同时出现（即不成环的情况），
            // 另外一个就是首尾同时出现（成环），第二种情况意味着没有选到的元素在不成环时也连在一起，因此只要让这些没选到的元素最小就行
            System.out.println(Math.max(max, sum - min));
        }
    }
}
