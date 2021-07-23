package interview.meituan.meituan10;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/4/25 23:18
 */

import java.util.Arrays;
import java.util.Scanner;


/**
 * 我们需要明白，无论是什么排列的正则序列，改动最少的方案一定是对输入序列和正则序列中相同排名的元素进行修改，
 * 即输入序列中排名第 i 的元素应该修改为正则序列中的 i。
 * 除此之外，其他的任何方案都至少存在一个数，使得它并不是修改为离它最近的正则序列中的数，这样就会使得修改次数增多。
 */
public class Main2 {
    public static void main(String[] args) {
        int minCount = new Main2().minCount();
        System.out.println(minCount);
    }

    public int minCount() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        Arrays.sort(arr);
        int res = 0;

        for (int i = 0; i < n; i++) {
            res += Math.abs(arr[i] - (i + 1));
        }

        return res;
    }
}
