package interview.meituan.meituan7;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/7 21:02
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int count = 0;
        for (int i = M; i <= N; i++) {
            if (vaild(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean vaild(int x) {
        int[] nums = new int[6];
        Set<Integer> set = new HashSet<>();
        for (int i = 5; i >= 0; i--) {
            nums[i] = x % 10;
            x = x / 10;
            if (!set.add(nums[i])) {
                return false;
            }
            // 题目有毒，去掉不为0的条件才是对的
//            if (i / 2 == 0) {
//                return nums[i] != 0;
//            }
        }
        int AB = nums[0] * 10 + nums[1];
        int CD = nums[2] * 10 + nums[3];
        int EF = nums[4] * 10 + nums[5];
        return (AB + CD) == EF;
    }
}
